package com.wat.zpm.repository.role;

import com.wat.model.Role;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class RoleRepositoryServiceImpl implements RoleRepositoryService {

    private final RoleEntityMapper roleEntityMapper;
    private final RoleRepository roleRepository;

    public RoleRepositoryServiceImpl(RoleEntityMapper roleEntityMapper, RoleRepository roleRepository) {
        this.roleEntityMapper = roleEntityMapper;
        this.roleRepository = roleRepository;
    }

    @Override
    public Set<Role> list() {
        return roleRepository.findAll()
                .stream()
                .map(roleEntityMapper::roleEntityToRole)
                .collect(Collectors.toSet());
    }

    @Override
    public Role findById(int id) {
        return roleEntityMapper.roleEntityToRole(roleRepository.getOne(id));
    }

    @Override
    public Set<Role> findByIds(Set<Integer> ids) {
        return roleRepository.findAllByIdIn(ids)
                .stream()
                .map(roleEntityMapper::roleEntityToRole)
                .collect(Collectors.toSet());
    }

    @Override
    public Role update(Role role) {
        return null;
    }

}
