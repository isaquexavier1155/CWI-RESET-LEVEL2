package br.com.cwi.reset.isaquexavierdossantos;

public enum Genero {
    ACAO("Acao"),
    AVENTURA("Aventura"),
    COMEDIA("Comédia"),
    DOCUMENTARIO("Documentário"),
    DRAMA("Drama"),
    ESPIONAGEM("Espionagem"),
    FICCAO_CIENTIFICA("Ficção Científica"),
    GUERRA("Guerra"),
    MISTERIO("Mistério"),
    MUSICAL("Musical"),
    POLICIAL("Policial"),
    ROMANCE("Romance"),
    TERROR("Terror");

    private String generos;

    Genero(String generos) {//construtor enum
    }

    //return
    public String getGenero(){return generos;}//return
}
