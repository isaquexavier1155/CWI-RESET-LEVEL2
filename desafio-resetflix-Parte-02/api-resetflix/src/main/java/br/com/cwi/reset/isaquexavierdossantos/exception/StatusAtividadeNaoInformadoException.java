package br.com.cwi.reset.isaquexavierdossantos.exception;

import  org.springframework.http.HttpStatus ;
import  org.springframework.web.bind.annotation.ResponseStatus ;

@ResponseStatus ( HttpStatus . BAD_REQUEST )
public  class  StatusAtividadeNaoInformadoException  extends  CampoNaoInformadoException {
    public  StatusAtividadeNaoInformadoException () {
        super ( " statusAtividade " );
    }
}