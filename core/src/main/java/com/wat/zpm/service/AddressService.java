package com.wat.zpm.service;

import com.wat.model.Address;

import java.util.List;

public interface AddressService {
    List<Address> list();

    Address findById(int id);

    Address save(Address address);

    void delete(int id);
}
