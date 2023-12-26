package com.iffat.springboot.rest.validation;

import com.iffat.springboot.rest.repositories.ProductRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IsExistDBValidation implements ConstraintValidator<IsExistDB, String> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return !productRepository.existsBySku(value);
    }
}
