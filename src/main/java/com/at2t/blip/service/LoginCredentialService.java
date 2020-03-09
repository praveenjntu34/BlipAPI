package com.at2t.blip.service;

import com.at2t.blip.dao.LoginCredential;
import com.at2t.blip.dao.Person;
import com.at2t.blip.dao.State;
import com.at2t.blip.repository.LoginCredentialRepository;
import com.at2t.blip.repository.PersonRepository;
import com.at2t.blip.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class LoginCredentialService {

    @Autowired
    LoginCredentialRepository loginCredentialRepository;


    @Transactional
    public LoginCredential checkEmail(String email) {
        return loginCredentialRepository.checkWhetherEmailExists(email);
    }


    @Transactional
    public void changePassword(String email, String password) {
         loginCredentialRepository.changepassword(email, password);
    }


}
