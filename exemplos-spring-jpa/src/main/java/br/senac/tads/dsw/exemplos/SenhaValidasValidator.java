package br.senac.tads.dsw.exemplos;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SenhaValidasValidator implements ConstraintValidator<SenhasValidas, DadosPessoais> {

    @Override
    public boolean isValid(DadosPessoais value, ConstraintValidatorContext context) {
        if (value != null && value.getSenha().equals(value.getSenhaRepetida())) {
            return true;
        }
        return false;
    }
    
}
