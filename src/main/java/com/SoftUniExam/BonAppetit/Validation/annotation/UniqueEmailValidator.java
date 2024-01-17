package com.SoftUniExam.BonAppetit.Validation.annotation;

import com.SoftUniExam.BonAppetit.Validation.annotation.annotation.UniqueEmail;
import com.SoftUniExam.BonAppetit.Repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {


private final UserRepository userRepository;


    public UniqueEmailValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

    return userRepository.findByEmail(value).isEmpty();

    }
}