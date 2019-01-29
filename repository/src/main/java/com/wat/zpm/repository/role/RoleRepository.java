package com.wat.zpm.repository.role;

import com.wat.zpm.repository.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
    Set<RoleEntity> findAllByIdIn(Set<Integer> ids);
}
