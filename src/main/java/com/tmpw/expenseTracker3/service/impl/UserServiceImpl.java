package com.tmpw.expenseTracker3.service.impl;


import com.tmpw.expenseTracker3.dto.UserRegisterDto;
import com.tmpw.expenseTracker3.exceptions.ItemAlreadyExistException;
import com.tmpw.expenseTracker3.model.User;
import com.tmpw.expenseTracker3.repository.UserRepository;
import com.tmpw.expenseTracker3.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    // ====fields====
    private PasswordEncoder bCryptPasswordEncoder;
    private UserRepository userRepository;

    // ====constructor====
    public UserServiceImpl(PasswordEncoder bCryptPasswordEncoder, UserRepository userRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
    }

    // ====public methods====
    @Override
    public User create(UserRegisterDto userRegister) {
        if (userRepository.existsByEmail(userRegister.getEmail())) {
            throw new ItemAlreadyExistException("User is already register with email:" + userRegister.getEmail());
        }
        com.tmpw.expenseTracker3.model.User newUser = new com.tmpw.expenseTracker3.model.User();
        BeanUtils.copyProperties(userRegister, newUser);
        newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
        return userRepository.save(newUser);    }

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
