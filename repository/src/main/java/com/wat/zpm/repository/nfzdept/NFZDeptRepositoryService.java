package com.wat.zpm.repository.nfzdept;

import com.wat.model.Doctor;
import com.wat.model.NFZDept;

import java.util.Set;

public interface NFZDeptRepositoryService {
    Set<NFZDept> list();

    NFZDept findById(int id);

    Set<NFZDept> findByIds(Set<Integer> ids);

    NFZDept update(NFZDept nfzDept);

    NFZDept save(NFZDept nfzDept);
}
