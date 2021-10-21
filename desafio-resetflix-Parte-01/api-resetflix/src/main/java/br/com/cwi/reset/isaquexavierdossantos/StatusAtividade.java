package br.com.cwi.reset.isaquexavierdossantos;

public enum StatusAtividade {
    EM_ATIVIDADE("Em Atividade"),
    ENCERRADO("Encerrado");

    private String statusAtividade;

    StatusAtividade(String statusAtividade) {//metodo construtor
    }
    public String getStatusAtividade(){return statusAtividade;}//return
    //nao criei construtores
}
