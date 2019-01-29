package com.wat.zpm.repository.contactdetails;

import com.wat.zpm.repository.AddressEntity;
import com.wat.zpm.repository.ContactDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

interface ContactDetailsRepository extends JpaRepository<ContactDetailsEntity, Integer> {
}
