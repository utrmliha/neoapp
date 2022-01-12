package com.br.neoapp.validation;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.regex.Pattern;

@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {Celular.CelularValidation.class})
public @interface Celular {

    String message() default "Número celular fora do padrão (XX) X XXXX-XXXX.";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    class CelularValidation implements ConstraintValidator<Celular, String> {

        @Override
        public void initialize(Celular constraintAnnotation) {
            ConstraintValidator.super.initialize(constraintAnnotation);
        }

        @Override
        public boolean isValid(String celular, ConstraintValidatorContext constraintValidatorContext) {
            return Pattern.matches("(^[(]\\d{2,2}[)]\\s{1,1}\\d{1,1}\\s{1,1}\\d{4,4}[-]{1,1}\\d{4,4}$)", celular);
        }
    }
}
