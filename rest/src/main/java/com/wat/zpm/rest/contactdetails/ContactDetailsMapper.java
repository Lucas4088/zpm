package com.wat.zpm.rest.contactdetails;

import com.wat.model.ContactDetails;
import com.wat.model.dto.UpdateAddressDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ContactDetailsMapper {
    ContactDetails addContactDetailsRequestToContactDetails(AddContactDetailsRequest contactDetails);

    UpdateAddressDTO updateContactRequestToUpdateContactDTO(UpdateContactDetailsRequest updateContactDetailsRequest);
}
