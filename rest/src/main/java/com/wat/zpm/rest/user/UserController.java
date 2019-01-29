package com.wat.zpm.rest.user;

import com.wat.model.User;
import com.wat.zpm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import static com.wat.zpm.rest.user.UserController.ENDPOINT;

@RestController
@RequestMapping(ENDPOINT)
public class UserController {
    public static final String ENDPOINT = "/user";

    private final UserService userService;

    private final UserMapper userMapper; /*= Mappers.getMapper(UserMapper.class);*/

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/list")
    @PreAuthorize("hasAuthority('PREVIEW_USER')")
    public List<UserResponse> list() {
        return userService.list()
                .stream()
                .map(userMapper::userToUserResponse)
                .collect(Collectors.toList());
    }

    @GetMapping
    public CurrentUserResponse getCurrentUser(Authentication authentication) {
        User user = userService.findByUsername(authentication.getName());

        return userMapper.userToCurrentUser(user);
    }

    /*@GetMapping("/patient")
    public List<Patient>*/

    @GetMapping("/{id}")
    public UserResponse findById(@PathVariable int id) {
        return userMapper.userToUserResponse(userService.findById(id));
    }

    @PostMapping("/sign-up")
    public UserResponse signUp(@RequestBody UserSignUpRequest userSignUpRequest) {
        return userMapper.userToUserResponse(userService.signUp(
                userMapper.userSignUpRequestToUser(userSignUpRequest)
        ));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('MANAGE_USER')")
    public UserResponse update(@PathVariable int id, @RequestBody UpdateUserRequest updateUserRequest) {
        return userMapper.userToUserResponse(userService.update(
                userMapper.updateUserRequestToUpdateUserDTO(updateUserRequest, id)
        ));
    }
}
