package com.SoftUniExam.BonAppetit.Service;

import com.SoftUniExam.BonAppetit.Model.Entity.User;
import com.SoftUniExam.BonAppetit.Model.Service.UserServiceModel;

public interface UserService {

    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByNameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    User findUserByUsername(String value);

    User findUserByEmail(String value);
}
