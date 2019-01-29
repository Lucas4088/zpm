package com.wat.zpm.repository.address;

import com.wat.model.Address;

import java.util.List;

public interface AddressRepositoryService {
    Address save(Address address);

    Address findById(int id);

    List<Address> list();

}
