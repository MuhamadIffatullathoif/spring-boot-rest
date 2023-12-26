package com.iffat.springboot.rest;

import com.iffat.springboot.rest.entities.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProductValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",null, "tidak boleh kosong");

        if (product.getDescription() == null || product.getDescription().isBlank()) {
            errors.rejectValue("description", null,"tidak boleh kosong");
        }

        if (product.getPrice() == null) {
            errors.rejectValue("price", null,"tidak boleh null");
        } else if (product.getPrice() < 500) {
            errors.rejectValue("price",null,"minimal 500");
        }
    }
}
