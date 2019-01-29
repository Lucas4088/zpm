package com.wat.zpm.rest.address;

import com.wat.model.Address;
import com.wat.model.dto.UpdateAddressDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressMapper {
    Address addAddressRequestToAddress(AddAddressRequest addAddressRequest);

    UpdateAddressDTO updateAddressRequestToUpdateAddressDTO(UpdateAddressRequest updateAddressRequest);

}
