package com.wat.zpm.repository.user;

import com.wat.model.Role;
import com.wat.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
class UserRepositoryServiceImpl implements UserRepositoryService {

    private final UserEntityMapper userMapper;
    private final UserRepository userRepository;

    public UserRepositoryServiceImpl(UserEntityMapper userMapper, UserRepository userRepository1) {
        this.userMapper = userMapper;
        this.userRepository = userRepository1;
    }

    public User saveUser(User user) {
        return userMapper.userEntityToUser(userRepository.save(userMapper.userToUserEntity(user)));
    }

    public User findById(int id) {
        return userMapper.userEntityToUser(
                userRepository.getOne(id)
        );
    }

    @Override
    public User update(User user) {
        return userMapper.userEntityToUser(
                userRepository.save(
                        userMapper.userToUserEntity(user)
                )
        );
    }

    public User findByUsername(String username) {
        return userMapper.userEntityToUser(
                userRepository.findByUsername(username)
        );
    }

    @Override
    public User findByEmail(String email) {
        return userMapper.userEntityToUser(
                userRepository.findByEmail(email)
        );
    }

    public List<User> list() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::userEntityToUser)
                .collect(Collectors.toList());
    }
}
