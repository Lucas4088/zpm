package com.wat.zpm.repository.address;

import com.wat.model.Address;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class AddressRepositoryServiceImpl implements AddressRepositoryService {

    private final AddressRepository addressRepository;
    private final AddressEntityMapper addressEntityMapper;

    public AddressRepositoryServiceImpl(AddressRepository addressRepository, AddressEntityMapper addressEntityMapper) {
        this.addressRepository = addressRepository;
        this.addressEntityMapper = addressEntityMapper;
    }

    @Override
    public Address save(Address address) {
        return addressEntityMapper.addressEntityToAddress(
                addressRepository.save(
                        addressEntityMapper.addressToAddressEntity(address)
                )
        );
    }

    @Override
    public Address findById(int id) {
        return addressEntityMapper.addressEntityToAddress(
                addressRepository.getOne(id)
        );
    }

    @Override
    public List<Address> list() {
        return null;
    }
}
