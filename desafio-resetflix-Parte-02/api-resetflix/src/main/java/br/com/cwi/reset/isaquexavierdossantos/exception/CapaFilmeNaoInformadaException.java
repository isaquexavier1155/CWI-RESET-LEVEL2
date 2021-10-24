package br.com.cwi.reset.isaquexavierdossantos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CapaFilmeNaoInformadaException extends CampoNaoInformadoException {
    public CapaFilmeNaoInformadaException() {
        super("capaFilme");
    }
}