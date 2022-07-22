package com.tmpw.expenseTracker3.controller;

import com.tmpw.expenseTracker3.dto.LoginCredentials;
import com.tmpw.expenseTracker3.dto.UserRegister;
import com.tmpw.expenseTracker3.model.User;
import com.tmpw.expenseTracker3.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public void login(@RequestBody LoginCredentials loginCredentials){

    }

    @PostMapping("/register")
    public User register(@Valid @RequestBody UserRegister userRegister){
        return userService.createUser(userRegister);
    }


}
