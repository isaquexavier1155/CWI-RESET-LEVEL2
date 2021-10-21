package br.com.cwi.reset.josealencar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NascidosNoFuturoException extends Exception {
    public NascidosNoFuturoException(String tipo) {
        super(String.format("Não é possível cadastrar %s não nascidos.", tipo));
    }
}
