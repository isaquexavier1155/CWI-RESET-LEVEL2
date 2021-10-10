package br.com.cwi.reset.isaquexavierdossantos;

public class PersonagemAtor {
    private Integer id;
    private Ator ator;
    private String nomePersonagem;
    private String descricaoPersonagem;
    private TipoAtuacao tipoAtuacao;//ver se nao vai dar comflito entre essa variavel e a mesma da classe num TipoAtuacao
    private String personagens;
    PersonagemAtor(String personagens) {//construtor enum
    }


    //return
    public String getPersonagemAtor(){return personagens;}
}

