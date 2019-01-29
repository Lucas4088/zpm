package com.wat.zpm;

import com.wat.model.Address;
import com.wat.zpm.repository.address.AddressRepositoryService;
import com.wat.zpm.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepositoryService addressRepositoryService;

    public AddressServiceImpl(AddressRepositoryService addressRepositoryService) {
        this.addressRepositoryService = addressRepositoryService;
    }

    @Override
    public List<Address> list() {
        return null;
    }

    @Override
    public Address findById(int id) {
        return null;
    }

    @Override
    public Address save(Address address) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
