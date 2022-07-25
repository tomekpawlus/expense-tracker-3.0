package com.tmpw.expenseTracker3.service;

import com.tmpw.expenseTracker3.model.User;
import com.tmpw.expenseTracker3.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {


    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;


    @Test
    void should_create_user() {
        //given
        User user1 = new User()
        //when
        when(userRepository.save(user1))
        //then

    }
}