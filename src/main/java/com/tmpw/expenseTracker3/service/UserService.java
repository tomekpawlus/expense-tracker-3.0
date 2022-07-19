package com.tmpw.expenseTracker3.service;

import org.springframework.security.core.userdetails.User;

public interface UserService {

    User create (String name, String password);

    User readUser();

    User updateUser();

    void deleteUser();


}
