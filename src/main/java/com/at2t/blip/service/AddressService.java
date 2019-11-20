package com.at2t.blip.service;

import com.at2t.blip.dao.Address;
import com.at2t.blip.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Transactional
    public Address setAddress(Address address){
        return addressRepository.save(address);
    }

    public Optional<Address> findAddress(int addressId){
        return addressRepository.findById(addressId);
    }
}
