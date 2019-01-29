package com.wat.zpm.repository.address;

import com.wat.model.Address;
import com.wat.zpm.repository.AddressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressEntityMapper {
    Address addressEntityToAddress(AddressEntity addressEntity);

    AddressEntity addressToAddressEntity(Address address);
}
