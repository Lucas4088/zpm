package com.wat.zpm.repository.user;

import com.wat.model.User;
import com.wat.zpm.repository.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserEntityMapper {
    UserEntity userToUserEntity(User user);

    User userEntityToUser(UserEntity userEntity);
}
