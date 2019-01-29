package com.wat.zpm.service;


import com.wat.model.ContactDetails;

import java.util.List;

public interface ContactDetailsService {
    List<ContactDetails> list();

    ContactDetails findById(int id);

    ContactDetails save(ContactDetails address);
}
