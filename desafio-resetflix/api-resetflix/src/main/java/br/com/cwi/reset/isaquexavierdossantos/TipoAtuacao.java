package br.com.cwi.reset.isaquexavierdossantos;

public enum TipoAtuacao {
    PRINCIPAL("Principal"),
    COADJUVANTE("Coadjuvante");

    private String tipoAtuacao;

    //construtor abaixo:
    TipoAtuacao(String tipoAtuacao) {

    }

    public String getTipoAtuacao(){return tipoAtuacao;}//return
}
