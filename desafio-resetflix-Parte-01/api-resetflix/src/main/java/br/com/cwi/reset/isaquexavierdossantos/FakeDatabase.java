package br.com.cwi.reset.isaquexavierdossantos;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class FakeDatabase {

  //se usa aquela classe AtorRequest pra simular essa requisição (vai simular uma DTO, um objeto que transfere dados). (editado)
  //[16:52]
  //na classe AtorService é onde recebe a request para criar o Ator,
  // mas veja que no banco de dados ele recebe Ator e não AtorRequest,
  // dessa forma se usa o AtorService para transformar a classe de requisição na classe Ator

    private List<Ator> atores = new ArrayList<>();//pede dados da classe Ator e retorna lista NA variavel atores



    private List<Diretor> diretores = new ArrayList<>();


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