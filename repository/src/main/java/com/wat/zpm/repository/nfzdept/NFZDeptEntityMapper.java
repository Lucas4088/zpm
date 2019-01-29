package com.wat.zpm.repository.nfzdept;

import com.wat.model.Doctor;
import com.wat.model.NFZDept;
import com.wat.zpm.repository.DoctorEntity;
import com.wat.zpm.repository.NFZDeptEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface NFZDeptEntityMapper {
    NFZDept nfzDeptEntityToNFZDept(NFZDeptEntity nfzDeptEntity);

    NFZDeptEntity nfzDeptToNFZDeptEntity(NFZDept nfzDept);
}
