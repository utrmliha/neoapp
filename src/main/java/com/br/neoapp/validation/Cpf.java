package com.br.neoapp.validation;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.InputMismatchException;
import java.util.regex.Pattern;

@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {Cpf.CpfValidation.class})
public @interface Cpf {

    String message() default "Cpf inválido ou fora do padrão XXX.XXX.XXX-XX.";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    class CpfValidation implements ConstraintValidator<Cpf, String>{

        @Override
        public void initialize(Cpf constraintAnnotation) {
            ConstraintValidator.super.initialize(constraintAnnotation);
        }

        @Override
        public boolean isValid(String cpf, ConstraintValidatorContext constraintValidatorContext) {
            if(!Pattern.matches("(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)", cpf))
                return false;

            cpf = cpf.replace(".","").replace("-", "");

            if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222") || cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555") || cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888") || cpf.equals("99999999999") || (cpf.length() != 11))
                return (false);

            char dig10, dig11;
            int sm, i, r, num, peso;

            try {
                sm = 0;
                peso = 10;
                for (i = 0; i < 9; i++) {
                    num = cpf.charAt(i) - 48;
                    sm = sm + (num * peso);
                    peso = peso - 1;
                }

                r = 11 - (sm % 11);
                if (r == 10 || r == 11)
                    dig10 = '0';
                else
                    dig10 = (char) (r + 48);

                sm = 0;
                peso = 11;
                for (i = 0; i < 10; i++) {
                    num = cpf.charAt(i) - 48;
                    sm = sm + (num * peso);
                    peso = peso - 1;
                }

                r = 11 - (sm % 11);
                if (r == 10 || r == 11)
                    dig11 = '0';
                else
                    dig11 = (char) (r + 48);

                return (dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10));
            } catch (InputMismatchException erro) {
                return false;
            }
        }
    }
}
