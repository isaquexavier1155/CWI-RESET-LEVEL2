package br.com.cwi.reset.josealencar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AnoInicioAtividadeInvalidoException extends Exception {
    public AnoInicioAtividadeInvalidoException(String tipo) {
        super(String.format("Ano de início de atividade inválido para o %s cadastrado.", tipo));
    }
}
