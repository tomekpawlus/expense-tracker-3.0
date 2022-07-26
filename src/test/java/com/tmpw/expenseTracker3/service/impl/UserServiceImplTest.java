package com.tmpw.expenseTracker3.service.impl;

import com.tmpw.expenseTracker3.dto.UserRegister;
import com.tmpw.expenseTracker3.exceptions.ItemAlreadyExistException;
import com.tmpw.expenseTracker3.model.User;
import com.tmpw.expenseTracker3.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {UserServiceImpl.class})
@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Test
    void shouldThrowNewItemAlreadyExistException() {
        //given
        User user = new User();
        user.setCreatedAt(mock(Timestamp.class));
        user.setId(123L);
        user.setPassword("12345");
        user.setUpdatedAt(mock(Timestamp.class));
        user.setUsername("test");

        //when
        when(userRepository.existsByUsername(any())).thenReturn(true);

        //then
        assertThrows(ItemAlreadyExistException.class,
                () -> userServiceImpl.createUser(new UserRegister("test", "12345")));
        verify(userRepository).existsByUsername(any());
    }

    @Test
    void shouldCreateNewUser() {
        //given
        User user = new User();
        user.setCreatedAt(mock(Timestamp.class));
        user.setId(123L);
        user.setPassword("12345");
        user.setUpdatedAt(mock(Timestamp.class));
        user.setUsername("test");

        //when
        when(userRepository.existsByUsername(any())).thenReturn(false);
        when(userRepository.save(any())).thenReturn(user);
        when(passwordEncoder.encode(any())).thenReturn("secret");

        //then
        User createdUser = userServiceImpl.createUser(new UserRegister("test", "12345"));

        assertSame(user, createdUser);

        verify(userRepository).existsByUsername(any());
        verify(userRepository).save(any());
        verify(passwordEncoder).encode(any());
    }

}

