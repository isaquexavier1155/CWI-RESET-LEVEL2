package br.com.cwi.reset.isaquexavierdossantos.exception;

import  org.springframework.http.HttpStatus ;
import  org.springframework.web.bind.annotation.ResponseStatus ;

@ResponseStatus ( HttpStatus . BAD_REQUEST )
public  class  AnoLancamentoNaoInformadoException  extends  CampoNaoInformadoException {
    public  AnoLancamentoNaoInformadoException () {
        super ( " anoLancamento " );
    }
}