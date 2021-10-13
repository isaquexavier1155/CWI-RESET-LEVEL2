package br.com.cwi.reset.isaquexavierdossantos;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;


public class AtorService{
    //AtorService é onde você vai definir as regras de negócio, as validações e limitações na hora de manipular os atores.

    //Isso usamos o atorService para transformar um AtorRequest em Ator pra  proteger
    // a camada interna da aplicacao do mundo externo

    private FakeDatabase fakeDatabase;
    private AtorRequest atorRequest;

    private String nomme;

    public AtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }//metodo construtor1


    // Demais métodos da classe abaixo. em cima foi copiado do projeto

    public AtorService(AtorRequest atorRequest) { this.atorRequest = atorRequest;}//metodo construtor2


    //agora
    public List<Ator> criarAtor(AtorRequest atorRequest)throws AvaliacaoForaDoPadraoException {

        List<Ator> atores = new ArrayList<>();
        Ator ator1 = new Ator(01,"Will Smith", LocalDate.of(1975, Month.APRIL, 12),StatusCarreira.EM_ATIVIDADE,1989);
        Ator ator2 = new Ator(02,"Leonardo di Capri",LocalDate.of(1979, Month.JANUARY, 21),StatusCarreira.EM_ATIVIDADE,1993);
        Ator ator3 = new Ator(03,"Leonardo di Capri",LocalDate.of(1979, Month.JANUARY, 21),StatusCarreira.EM_ATIVIDADE,1993);
        atores.add(ator1);
        atores.add(ator2);
        atores.add(ator3);

        return atores;
    }
   //Criei esse geter para chamar na aplicacao

    public AtorRequest getAtorRequest() {
        return atorRequest;
    }


}