package br.com.cwi.reset.isaquexavierdossantos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NomeSobrenomeObrigatorioException extends Exception {
    public NomeSobrenomeObrigatorioException(final String tipo) {
        super(String.format("Deve ser informado no mínimo nome e sobrenome para o %s.", tipo));
    }
}
