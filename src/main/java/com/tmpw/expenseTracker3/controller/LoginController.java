package com.tmpw.expenseTracker3.controller;

import com.tmpw.expenseTracker3.dto.LoginCredentials;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {


    @PostMapping("/login")
    public void login(@RequestBody LoginCredentials loginCredentials){

    }
}
