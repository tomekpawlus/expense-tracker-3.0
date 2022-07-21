package com.tmpw.expenseTracker3.controller;

import com.tmpw.expenseTracker3.dto.UserLoginDto;
import com.tmpw.expenseTracker3.dto.UserRegisterDto;
import com.tmpw.expenseTracker3.model.User;
import com.tmpw.expenseTracker3.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public void login(@RequestBody UserLoginDto userLoginDto){

    }

    private void authenticate (String email, String password) throws Exception{

    }
    @PostMapping("/register")
    public ResponseEntity<User> register (@RequestBody UserRegisterDto userRegister){

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(userRegister));
    }
}
