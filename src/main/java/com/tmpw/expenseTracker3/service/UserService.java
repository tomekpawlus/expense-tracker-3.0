package com.tmpw.expenseTracker3.service;

import com.tmpw.expenseTracker3.dto.UserRegister;
import com.tmpw.expenseTracker3.model.User;

public interface UserService {

    User createUser(UserRegister user);
    User readUser ();
    User updateUser(UserRegister user);
    void deleteUser();
    User getLoggedInUser();


}
