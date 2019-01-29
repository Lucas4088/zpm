package com.wat.zpm.repository.contactdetails;

import com.wat.model.ContactDetails;
import com.wat.zpm.repository.ContactDetailsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ContactDetailsEntityMapper {
    ContactDetails contactDetailsEntityToContactDetails(ContactDetailsEntity entity);

    ContactDetailsEntity contactDetailsToContactDetailsEntity(ContactDetails contactDetails);
}
