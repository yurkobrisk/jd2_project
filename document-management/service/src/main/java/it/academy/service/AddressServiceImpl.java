package it.academy.service;

import it.academy.model.Address;
import it.academy.repository.AddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private static final Logger log =
            LoggerFactory.getLogger(AddressService.class);

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Address> readAllAddress() {
        return addressRepository.findAll();
    }

    @Override
    public Address readAddress(String id) {
        return addressRepository.getOne(id);
    }

    @Override
    public Address saveAddress(Address address) {
        return addressRepository.saveAndFlush(address);
    }

    @Override
    public Address updateAddress(Address address) {
        return addressRepository.saveAndFlush(address);
    }

    @Override
    public void deleteAddress(String id) {
        addressRepository.deleteById(id);
    }
}
