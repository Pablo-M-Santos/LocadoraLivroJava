package com.locadora.locadoraLivro.Renters.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TelephoneValidator implements ConstraintValidator<ValidTelephone, String> {

    private static final String PHONE_PATTERN = "\\d{2} \\d{5}-\\d{4}";
    private static final String PHONE_PATTERN_SIMPLE = "\\d{11}";

    @Override
    public void initialize(ValidTelephone constraintAnnotation) {
    }

    @Override
    public boolean isValid(String telephone, ConstraintValidatorContext context) {
        if (telephone == null || telephone.isEmpty()) {
            return false;
        }
        return telephone.matches(PHONE_PATTERN) || telephone.matches(PHONE_PATTERN_SIMPLE);
    }
}
