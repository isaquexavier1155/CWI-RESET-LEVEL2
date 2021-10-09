

public class Aplicacao {

    public static void main(String[] args) {
        Diretor diretor = new Diretor("Gustav barm", 51, 50);

        Filme Avatar = new Filme("Avatar", "Filme selvagem", 180, 2014, 5.0, diretor);
        Filme BreakingBad = new Filme("BreakingBad", "Filme superacao", 60, 2011, 4.8, diretor);

        Avatar.reproduzir();
        BreakingBad.reproduzir();

        Diretor diretor2 = new Diretor("Stiven Spelberg", 56, Genero.MASCULINO);
        Ator ator = new Ator("Leonardo di Capri", 78, Genero.MASCULINO);
        diretor2.dadosDiretor();
        ator.dadosAtor();

    }
}