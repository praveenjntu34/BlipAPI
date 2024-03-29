package com.at2t.blip.security;

import com.at2t.blip.dao.LoginCredential;
import com.at2t.blip.repository.InstitutionTypeRepository;
import com.at2t.blip.repository.LoginCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlipUserDetailsService implements UserDetailsService {

    @Autowired
    LoginCredentialRepository loginCredentialRepository;

    @Autowired
    InstitutionTypeRepository institutionTypeRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<LoginCredential> loginCredential = loginCredentialRepository.findByEmail(email);
        return loginCredential.map(BlipUserDetails::new).get();

    }
}
