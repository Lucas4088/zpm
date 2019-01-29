package com.wat.zpm.repository.address;

import com.wat.zpm.repository.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

interface AddressRepository extends JpaRepository<AddressEntity, Integer> {
}
