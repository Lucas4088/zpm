package com.wat.zpm.repository.contactdetails;

import com.wat.model.ContactDetails;

import java.util.List;

public interface ContactDetailsRepositoryService {
    ContactDetails save(ContactDetails contactDetails);

    ContactDetails findById(int id);

    List<ContactDetails> list();
}
