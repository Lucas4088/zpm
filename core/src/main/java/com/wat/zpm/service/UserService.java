package com.wat.zpm.service;

import com.wat.model.User;
import com.wat.model.dto.UpdateUserDTO;
import com.wat.model.exception.OperationForbiddenException;

import java.util.List;

public interface UserService {
    List<User> list();

    User findById(int id);

    User signUp(User user);

    User findByUsername(String name);

    void register(User user) throws OperationForbiddenException;

    User update(UpdateUserDTO updateUserDTO);

    void logut();
}
