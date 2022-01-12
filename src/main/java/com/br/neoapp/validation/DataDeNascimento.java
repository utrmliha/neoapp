package com.br.neoapp.validation;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.LocalDate;
import java.time.Period;

@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {DataDeNascimento.DataDeNascimentoValidation.class})
public @interface DataDeNascimento {

    String message() default "Data de nascimento inválida.";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    class DataDeNascimentoValidation implements ConstraintValidator<DataDeNascimento, LocalDate> {

        @Override
        public void initialize(DataDeNascimento constraintAnnotation) {
            ConstraintValidator.super.initialize(constraintAnnotation);
        }

        @Override
        public boolean isValid(LocalDate dataDeNascimento, ConstraintValidatorContext constraintValidatorContext) {
            int idade = Period.between(dataDeNascimento, LocalDate.now()).getYears();
            return idade > 0 && idade <= 120;
        }
    }
}
