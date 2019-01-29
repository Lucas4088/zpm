package com.wat.zpm;

import com.wat.model.ContactDetails;
import com.wat.zpm.repository.contactdetails.ContactDetailsRepositoryService;
import com.wat.zpm.service.ContactDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactDetailsServiceImpl implements ContactDetailsService {

    private final ContactDetailsRepositoryService contactDetailsRepositoryService;

    public ContactDetailsServiceImpl(ContactDetailsRepositoryService contactDetailsRepositoryService) {
        this.contactDetailsRepositoryService = contactDetailsRepositoryService;
    }

    @Override
    public List<ContactDetails> list() {
        return null;
    }

    @Override
    public ContactDetails findById(int id) {
        return null;
    }

    @Override
    public ContactDetails save(ContactDetails address) {
        return null;
    }
}
