package it.academy.service;

import it.academy.model.Address;

import java.util.List;

public interface AddressService {

    List<Address> readAllAddress();

    Address readAddress(String id);

    Address saveAddress(Address address);

    Address updateAddress(Address address);

    void deleteAddress(String id);
}
