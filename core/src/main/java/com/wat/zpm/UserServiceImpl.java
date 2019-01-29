package com.wat.zpm;

import com.wat.model.Role;
import com.wat.model.User;
import com.wat.model.dto.UpdateAddressDTO;
import com.wat.model.dto.UpdateUserDTO;
import com.wat.model.exception.OperationForbiddenException;
import com.wat.zpm.repository.role.RoleRepositoryService;
import com.wat.zpm.repository.user.UserRepositoryService;
import com.wat.zpm.service.UserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepositoryService userRepositoryService;
    private final RoleRepositoryService roleRepositoryService;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepositoryService userRepositoryService, RoleRepositoryService roleRepositoryService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepositoryService = userRepositoryService;
        this.roleRepositoryService = roleRepositoryService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    public List<User> list() {
        return userRepositoryService.list();
    }

    @Override
    public User findById(int id) {
        return userRepositoryService.findById(id);
    }

    @Override
    public User signUp(User user) {
        //check password
        String decryptedPassword = bCryptPasswordEncoder.encode(user.getPassword());

        user.setPassword(decryptedPassword);

        return userRepositoryService.saveUser(user);
    }

    @Override
    public User findByUsername(String name) {
        return userRepositoryService.findByUsername(name);
    }

    @Override
    public void register(User user) throws OperationForbiddenException {
        User user1;
        try {
            user1 = userRepositoryService.findByEmail(user.getEmail());
        } catch (EntityNotFoundException e) {
            throw new OperationForbiddenException("Użytkownik z danym mailem już istnieje");
        }

        try {
            user1 = userRepositoryService.findByUsername(user.getUsername());
        } catch (EntityNotFoundException e) {
            throw new OperationForbiddenException("Użytkownik z daną nazwą użytkownika już istnieje");
        }

        userRepositoryService.saveUser(user);
    }

    @Override
    public User update(UpdateUserDTO updateUserDTO) {
        User user = userRepositoryService.findById(updateUserDTO.getId());
        Set<Role> roles = roleRepositoryService.findByIds(updateUserDTO.getRolesId());

        UpdateAddressDTO address = updateUserDTO.getContactDetails().getAddress();

        user.getContactDetails().getAddress().setCountry(address.getCountry());
        user.getContactDetails().getAddress().setLocality(address.getLocality());
        user.getContactDetails().getAddress().setFlatNumber(address.getFlatNumber());
        user.getContactDetails().getAddress().setHouseNumber(address.getHouseNumber());
        user.getContactDetails().getAddress().setPostalCode(address.getPostalCode());
        user.getContactDetails().setPhoneNumber(updateUserDTO.getContactDetails().getPhoneNumber());
        user.setEmail(updateUserDTO.getEmail());
        user.setRoles(roles);
        return userRepositoryService.update(user);
    }

    @Override
    public void logut() {

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepositoryService.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),getAuthority(user));
    }

    private List<SimpleGrantedAuthority> getAuthority(User user) {
        return user.getRoles()
                .stream()
                .map(Role::getAuthorities)
                .flatMap(Collection::stream)
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
