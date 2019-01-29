package com.wat.zpm.repository.user;

import com.wat.zpm.repository.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUsername(String username);

    UserEntity findByEmail(String email);
}
