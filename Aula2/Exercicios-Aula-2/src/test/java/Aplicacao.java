
//package br.com.cwi.reset.aula.dois.exercicios;

public class Aplicacao {

    public static void main(String[] args) {
        Diretor diretor = new Diretor("Christopher Nolan", 51, 50);

        Filme interestelar = new Filme("Interestelar", "Filme muito bom", 120, 2014, 5.0, diretor);
        Filme batman = new Filme("Batman", "Filme muito bom", 120, 2011, 4.8, diretor);

        interestelar.reproduzir();
        batman.reproduzir();

        Diretor diretor2 = new Diretor("DICAPRI", 56, Genero.MASCULINO);
        Ator ator = new Ator("gASPAR", 78, Genero.MASCULINO);
        diretor2.dadosDiretor();
        ator.dadosAtor();

    }
}