package com.wat.zpm.repository.user;

import com.wat.model.Role;
import com.wat.model.User;

import java.util.List;

public interface UserRepositoryService {
    User saveUser(User user);

    User findById(int id);

    List<User> list();

    User update(User user);

    User findByUsername(String username);

    User findByEmail(String email);
}
