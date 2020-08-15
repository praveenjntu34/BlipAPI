package com.at2t.blip.service;

import com.at2t.blip.dao.Child;
import com.at2t.blip.dao.LoginCredential;
import com.at2t.blip.dao.Parent;
import com.at2t.blip.dao.Person;
import com.at2t.blip.dto.InstructorLoginResponse;
import com.at2t.blip.dto.LoginDetailsDto;
import com.at2t.blip.dto.ParentLoginDto;
import com.at2t.blip.dto.ParentProfileDto;
import com.at2t.blip.repository.*;
import com.at2t.blip.util.BlipResponse;
import com.at2t.blip.util.StatusEnum;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParentLoginService {


    @Autowired
    LoginCredentialRepository loginCredentialRepository;

    @Autowired
    ParentRepository parentRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    ChildRepository childRepository;


    public BlipResponse loginParent(String phoneNumber) {

        BlipResponse blipResponse = null;
        try {
            blipResponse = new BlipResponse();

            List<Object[]> login = loginCredentialRepository.getUserByPhoneNumber(phoneNumber);
            if(login != null) {

                List<ParentLoginDto> exp = login.stream()
                        .map(o -> new ParentLoginDto((int) o[0], (int) o[1], (int) o[2], (String) o[3], (String) o[4],
                                "Parent"))
                        .collect(Collectors.toList());

                blipResponse.setData(exp);
                blipResponse.setStatus(StatusEnum.success);
            } else {
                blipResponse.setStatus(StatusEnum.error);
                blipResponse.setData("Error occurred");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return blipResponse;
    }

    public BlipResponse getParentProfile(int parentId) {

        BlipResponse blipResponse = null;
        try {
            blipResponse = new BlipResponse();

            List<Object[]> login = loginCredentialRepository.getParentProfile(parentId);
            if(login != null) {

                List<ParentProfileDto> exp = login.stream()
                        .map(o -> new ParentProfileDto((int) o[0], (int) o[1], (int) o[2], (String) o[3], (String) o[4],
                                (String) o[5], (String) o[6], (String) o[7], (String) o[8], (String) o[9], (String) o[10], (int) o[11], (int) o[12]))
                        .collect(Collectors.toList());

                blipResponse.setData(exp.get(0));
                blipResponse.setStatus(StatusEnum.success);
            } else {
                blipResponse.setStatus(StatusEnum.error);
                blipResponse.setData("Error occurred");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return blipResponse;
    }

    public BlipResponse updateProfile(ParentProfileDto parentProfileDto) {

        BlipResponse blipResponse = null;
        try {

            Person person = new Person();
            person.setPersonId(parentProfileDto.getPersonId());
            person.setFirstName(parentProfileDto.getFirstName());
            person.setLastName(parentProfileDto.getLastName());
            person.setPersonTypeId(4);

            personRepository.save(person);

            Parent parent = new Parent();
            parent.setParentId(parentProfileDto.getParentId());
            parent.setSecondaryParentName(parentProfileDto.getSecondaryParentName());
            parent.setSecondaryPhoneNumber(parentProfileDto.getSecondaryPhoneNumber());
            parent.setRelTenantInstitutionId(parentProfileDto.getRelTenantInstitutionId());
            parent.setPersonId(person);

            parentRepository.save(parent);

            Child child = new Child();
            child.setChildId(parentProfileDto.getChildId());
            child.setAdmissionId(parentProfileDto.getAdmissionId());
            child.setChildrenName(parentProfileDto.getChildrenName());
            child.setEnabled(true);
            child.setSectionId(parentProfileDto.getSectionId());
            child.setParent(parent);

            childRepository.save(child);

            blipResponse = new BlipResponse();

            blipResponse.setStatus(StatusEnum.success);

            blipResponse.setData(child);

        } catch (Exception e) {
        blipResponse.setStatus(StatusEnum.error);
        blipResponse.setMessage("Error occurred");
            e.printStackTrace();
        }

        return blipResponse;
    }
}
