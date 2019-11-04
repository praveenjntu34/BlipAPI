package com.at2t.blip.controller;

import com.at2t.blip.dto.AuthenticationRequest;
import com.at2t.blip.dto.AuthenticationResponse;
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

@RestController
public class Authentication {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private BlipUserDetailsService blipUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authentication")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                            authenticationRequest.getPassword()));
        }catch (BadCredentialsException e) {
            throw new Exception( "Incorrect username or password");
        }

        final UserDetails userDetails = blipUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

}
