package com.wat.zpm.rest.user;

import com.wat.model.Authority;
import com.wat.model.Role;
import com.wat.model.User;
import com.wat.model.dto.UpdateUserDTO;
import org.mapstruct.*;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    User userResponseToUser(UserResponse userResponse);

    UserResponse userToUserResponse(User user);

    User userSignUpRequestToUser(UserSignUpRequest userSignUpRequest);

    User registerUserRequestToUser(RegisterUserRequest registerUserRequest);

    @Mappings({
            @Mapping(source = "roles", target = "roles", qualifiedByName = "rolesToStringList"),
            @Mapping(source = "roles", target = "authorities", qualifiedByName = "authoritiesToStringList")
    })
    CurrentUserResponse userToCurrentUser(User user);

    @Named("authoritiesToStringList")
    default Set<String> authoritiesToStringList(Set<Role> roles) {
        return roles.stream()
                .map(Role::getAuthorities)
                .flatMap(Collection::stream)
                .map(Authority::getName)
                .collect(Collectors.toSet());
    }

    @Named("rolesToStringList")
    default Set<String> rolesToStringList(Set<Role> roles) {
        return roles.stream()
                .map(Role::getName)
                .collect(Collectors.toSet());
    }

    UpdateUserDTO updateUserRequestToUpdateUserDTO(UpdateUserRequest updateUserRequest, int id);
}
