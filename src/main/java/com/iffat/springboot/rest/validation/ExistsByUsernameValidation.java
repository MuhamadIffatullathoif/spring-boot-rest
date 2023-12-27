package com.iffat.springboot.rest.validation;

import com.iffat.springboot.rest.services.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExistsByUsernameValidation implements ConstraintValidator<ExistsByUsername, String> {

    @Autowired
    private UserService userService;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        if(userService == null) {
            return true;
        }
        return !userService.existsByUsername(username);
    }
}
