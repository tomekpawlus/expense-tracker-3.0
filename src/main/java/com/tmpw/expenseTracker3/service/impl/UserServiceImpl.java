package com.tmpw.expenseTracker3.service.impl;


import com.tmpw.expenseTracker3.repository.UserRepository;
import com.tmpw.expenseTracker3.service.UserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    // ====fields====
    private final UserRepository userRepository;

    // ====constructor====
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ====public methods====
    @Override
    public User create(String name, String password) {
        return null;
    }

    @Override
    public User readUser() {
        return null;
    }

    @Override
    public User updateUser() {
        return null;
    }

    @Override
    public void deleteUser() {

    }
}
