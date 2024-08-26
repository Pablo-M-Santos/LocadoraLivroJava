package com.locadora.locadoraLivro.Users.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import com.locadora.locadoraLivro.Users.models.UserRoleEnum;

public class RentValidRoleValidator implements ConstraintValidator<ValidRole, UserRoleEnum> {

    @Override
    public void initialize(ValidRole constraintAnnotation) {
    }

    @Override
    public boolean isValid(UserRoleEnum value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return value == UserRoleEnum.ADMIN || value == UserRoleEnum.USER;
    }
}
