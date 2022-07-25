package com.tmpw.expenseTracker3.service.impl;

import com.tmpw.expenseTracker3.dto.UserRegister;
import com.tmpw.expenseTracker3.exceptions.ItemAlreadyExistException;
import com.tmpw.expenseTracker3.model.User;
import com.tmpw.expenseTracker3.repository.UserRepository;
import com.tmpw.expenseTracker3.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    private PasswordEncoder bCryptPasswordEncoder;
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User createUser(UserRegister user) {

        if (userRepository.existsByUsername(user.getUsername())) {
            throw new ItemAlreadyExistException("User is already register with email:" + user.getUsername());
        }
        User newUser = new User();
        BeanUtils.copyProperties(user, newUser);
        newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
        return userRepository.save(newUser);
    }


    @Override
    public User readUser() {
        return null;
    }

    @Override
    public User updateUser(UserRegister user) {
        return null;
    }

    @Override
    public void deleteUser() {

    }

    @Override
    public User getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        return userRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "User nto found for the email " + username));
    }
}

