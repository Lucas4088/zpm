package com.wat.zpm.security;

import com.wat.model.User;
import com.wat.model.exception.OperationForbiddenException;
import com.wat.zpm.rest.user.RegisterUserRequest;
import com.wat.zpm.rest.user.UserMapper;
import com.wat.zpm.security.config.JwtTokenUtil;
import com.wat.zpm.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.Validator;


//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;

    private final JwtTokenUtil jwtTokenUtil;

    private final UserService userService;

    private final UserMapper userMapper;

    private final Validator validator;

    private final BCryptPasswordEncoder bCryptPasswordEncoder ;// = new Bcr;

    public AuthenticationController(AuthenticationManager authenticationManager,
                                    JwtTokenUtil jwtTokenUtil,
                                    UserService userService,
                                    UserMapper userMapper, Validator validator, BCryptPasswordEncoder bCryptPasswordEncoder, BCryptPasswordEncoder bCryptPasswordEncoder1) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;
        this.userMapper = userMapper;
        this.validator = validator;
        //this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder1;
    }

    @PostMapping("/token/generate-token")
    public ResponseEntity login(@RequestBody LoginUserRequest loginUserRequest) throws AuthenticationException {
        // user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUserRequest.getUsername(),
                        loginUserRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final User user = userService.findByUsername(loginUserRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(user);
        return ResponseEntity.ok()
                .body(new AuthToken(token));
    }

    @PostMapping(value = "/register")
    public ResponseEntity register(@RequestBody @Valid RegisterUserRequest registerUserRequest) throws OperationForbiddenException {
        registerUserRequest.setPassword(bCryptPasswordEncoder.encode(registerUserRequest.getPassword()));
        userService.register(
                userMapper.registerUserRequestToUser(registerUserRequest));
        return ResponseEntity.ok()
                .build();
    }

    @PostMapping(value = "/log-out")
    public void logOut(HttpServletRequest request, HttpServletResponse response, Authentication auth) {
        new SecurityContextLogoutHandler().logout(request, null, auth);

        response.setStatus(HttpStatus.OK.value());
    }
}
