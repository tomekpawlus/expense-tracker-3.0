package com.tmpw.expenseTracker3.service;

import com.tmpw.expenseTracker3.dto.UserRegisterDto;
import com.tmpw.expenseTracker3.model.User;

public interface UserService {

    User create (UserRegisterDto userRegister);

    User readUser();

    User updateUser();

    void deleteUser();


}
