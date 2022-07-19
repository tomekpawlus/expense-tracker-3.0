package com.tmpw.expenseTracker3.service.impl;


import com.tmpw.expenseTracker3.dto.UserRegisterDto;
import com.tmpw.expenseTracker3.exceptions.ItemAlreadyExistException;
import com.tmpw.expenseTracker3.model.User;
import com.tmpw.expenseTracker3.repository.UserRepository;
import com.tmpw.expenseTracker3.service.UserService;
import org.springframework.beans.BeanUtils;
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
    public User create(UserRegisterDto userRegister) {
        if(userRepository.existsByEmail(userRegister.getEmail())){
            throw new ItemAlreadyExistException("User with email: "+ userRegister.getEmail() +" already exist.");
        }
        User newUser = new User();
        BeanUtils.copyProperties(userRegister, newUser);

        return newUser;
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
