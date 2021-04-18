package com.postgrs.JPAJavaDemoApp.config;

import com.postgrs.JPAJavaDemoApp.model.RegisterModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class SpringSimpleDtoValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return RegisterModel.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        if (errors.getErrorCount() == 0) {

            RegisterModel param = (RegisterModel) target;
            if (param.getFirstName() == null) {
                errors.reject("100", "userName can't be null");
            } else if (param.getLastName() == null) {
                errors.reject("100", "lastName can't be null");
            }
            if (!validate(param.getEmail())) {
                errors.reject("100", "not valid email or can't be null");
            }
        }

    }

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }
}