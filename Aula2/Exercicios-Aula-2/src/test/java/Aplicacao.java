public class Aplicacao {

    public static void main(String[] args) throws AvaliacaoForaDoPadraoException {
        //O throws ACIMA VALIDA QUE AQUI NAO VAI ACEITAR AVALIAÇAO FORA DOS PADROES DE 1 A 5
        Filme Avatar = new Filme("Avatar", "Filme selvagem", 180, 2014, 5.0,"James Cameron");
        Filme MeninoQueDescobriuOVento = new Filme("MeninoQueDescobriuOVento", "Filme ", 60, 2019, 4.8, " Chiwetel Ejiofor");
        System.out.println("-----------------Filme 1-----------------");
        Avatar.reproduzir();
        System.out.println("-----------------Filme 2-----------------");
        MeninoQueDescobriuOVento.reproduzir();
        System.out.println("--------------------------------------------------------------------------------");
        Diretor diretor = new Diretor("James Cameron", 71, Genero.MASCULINO);
        Ator ator = new Ator("Leonardo di Capri", 56, Genero.MASCULINO);
        System.out.println("-----------------Diretor-----------------");
        diretor.imprimeDadosPessoa();
        System.out.println("-----------------Ator Pricipal-----------------");
        ator.imprimeDadosPessoa();
    }
}