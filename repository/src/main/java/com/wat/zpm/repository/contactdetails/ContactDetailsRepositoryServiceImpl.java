package com.wat.zpm.repository.contactdetails;

import com.wat.model.ContactDetails;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
class ContactDetailsRepositoryServiceImpl implements ContactDetailsRepositoryService {

    private final ContactDetailsRepository contactDetailsRepository;
    private final ContactDetailsEntityMapper contactDetailsEntityMapper;

    public ContactDetailsRepositoryServiceImpl(ContactDetailsRepository contactDetailsRepository, ContactDetailsEntityMapper contactDetailsEntityMapper) {
        this.contactDetailsRepository = contactDetailsRepository;
        this.contactDetailsEntityMapper = contactDetailsEntityMapper;
    }

    @Override
    public ContactDetails save(ContactDetails contactDetails) {
        return contactDetailsEntityMapper.contactDetailsEntityToContactDetails(
                contactDetailsRepository.save(
                        contactDetailsEntityMapper.contactDetailsToContactDetailsEntity(contactDetails)
                ));
    }

    @Override
    public ContactDetails findById(int id) {
        return contactDetailsEntityMapper.contactDetailsEntityToContactDetails(
                contactDetailsRepository.getOne(id)
        );
    }

    @Override
    public List<ContactDetails> list() {
        return null;
    }
}
