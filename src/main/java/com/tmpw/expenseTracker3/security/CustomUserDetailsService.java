package com.tmpw.expenseTracker3.security;

import com.tmpw.expenseTracker3.model.User;
import com.tmpw.expenseTracker3.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User existingUser = userRepository
                .findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found for the email " + email));

        return new org.springframework.security.core.userdetails.User(existingUser.getEmail(), existingUser.getPassword(), new ArrayList<>());
    }
}
