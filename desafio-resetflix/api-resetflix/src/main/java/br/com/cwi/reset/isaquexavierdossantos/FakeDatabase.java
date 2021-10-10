package br.com.cwi.reset.isaquexavierdossantos;

import java.util.ArrayList;
import java.util.List;

public class FakeDatabase {

    private List<Ator> atores = new ArrayList<>();
    private List<Diretor> diretores = new ArrayList<>();
   // private List<PersonagemAtor> personagens = new ArrayList<>();
    //private List<Genero> generos = new ArrayList<>();




    public void persisteAtor(Ator ator) {
        atores.add(ator);
    }

    public List<Ator> recuperaAtores() {
        return atores;
    }


    public void persisteDiretor(Diretor diretor) {
        diretores.add(diretor);
    }

    public List<Diretor> recuperaDiretores() {
        return diretores;
    }
}