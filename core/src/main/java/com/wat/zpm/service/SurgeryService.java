package com.wat.zpm.service;

import com.wat.model.Surgery;

import java.util.List;

public interface SurgeryService {
    List<Surgery> list();

    Surgery findById(int id);

    Surgery save(Surgery surgery);

    void delete(int id);
}
