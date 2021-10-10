package br.com.cwi.reset.isaquexavierdossantos;

import java.util.List;

public class Filme {
    private Integer id;
    private String nome;
    private Integer anoLancamento;
    private Integer capaFilme;//ver qual tipo e capa filme
    private List<Genero> generos;//adicionei classe GENERO do tipo enum
    private Diretor diretor;    //variavel diretor ligada à classe Diretor
    private List<PersonagemAtor> personagens;//adicionei classe PersonagenAtor
    private String resumo;



    //ABAIXO TESTE DE LIST SÓ FUNCIONOU NO MAIN
   // List<String> dados = new ArrayList<>(); //testandoaqui
      // System.out.println("dados: "+generos);
}
