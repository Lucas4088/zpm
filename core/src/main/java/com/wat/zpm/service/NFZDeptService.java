package com.wat.zpm.service;

import com.wat.model.NFZDept;

import java.util.List;

public interface NFZDeptService {
    List<NFZDept> list();

    NFZDept findById(int id);

    NFZDept save(NFZDept nfzDept);

    void delete(int id);
}
