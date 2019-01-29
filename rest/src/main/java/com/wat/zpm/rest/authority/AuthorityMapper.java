package com.wat.zpm.rest.authority;

import com.wat.model.Authority;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthorityMapper {
    AuthorityResponse authorityToAuthorityResponse(Authority authority);
}
