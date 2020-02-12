package com.at2t.blip.controller;

import com.at2t.blip.dao.LoginCredential;
import com.at2t.blip.dto.AuthenticationRequest;
import com.at2t.blip.dto.AuthenticationResponse;
import com.at2t.blip.dto.InstructorResponseDto;
import com.at2t.blip.dto.LoginDetailsDto;
import com.at2t.blip.repository.LoginCredentialRepository;
import com.at2t.blip.security.BlipUserDetails;
import com.at2t.blip.security.BlipUserDetailsService;
import com.at2t.blip.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class Authentication {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private BlipUserDetailsService blipUserDetailsService;

    @Autowired
    LoginCredentialRepository loginCredentialRepository;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                            authenticationRequest.getPassword()));
        }catch (BadCredentialsException e) {
            throw new Exception( "Incorrect username or password");
        }

        final UserDetails userDetails = blipUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        List<Object[]> login = loginCredentialRepository.getLogin(authenticationRequest.getUsername());

        //LC.Email, LC.PhoneNumber, P.PersonId, P.FirstName, P.LastName, PT.PersonTypeId, PT.PersonTypeName

        List<LoginDetailsDto> exp = login.stream()
                .map(o -> new LoginDetailsDto((String) o[0], (String) o[1], (int) o[2], (String) o[3], (String) o[4],
                        (int) o[5], (String) o[6]))
                .collect(Collectors.toList());


        final String jwt = jwtUtil.generateToken(userDetails, exp.get(0));
        LoginDetailsDto loginResponse = exp.get(0);
        return ResponseEntity.ok(new AuthenticationResponse(jwt, loginResponse.getEmail(), loginResponse.getFirstName(), loginResponse.getLastName(),
                                                            loginResponse.getPhoneNumber(), loginResponse.getPersonTypeName(),loginResponse.getPersonId()));
    }

}
