package com.SoftUniExam.BonAppetit.Validation.annotation;

import com.SoftUniExam.BonAppetit.Service.Impl.UserServiceImpl;
import com.SoftUniExam.BonAppetit.Validation.annotation.annotation.UniqueUsername;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    private final UserServiceImpl userService;

    public UniqueUsernameValidator(UserServiceImpl userService) {
        this.userService = userService;
    }




    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return this.userService.findUserByUsername(value) == null;
    }
}