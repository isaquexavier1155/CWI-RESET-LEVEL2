package br.com.cwi.reset.isaquexavierdossantos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Aplicacao {

    public static void main(String[] args) {
        SpringApplication.run(Aplicacao.class, args);
    }
}









import java.time.LocalDate;
import java.time.Month;//importei essa classe por conta
import java.util.ArrayList;
import java.util.List;

//public class Aplicacao {


    //public static void main(String[] args) throws AvaliacaoForaDoPadraoException{
        // //EXCECAO 3 Criar terceira Exception

        //O throws ACIMA VALIDA QUE AQUI NAO VAI ACEITAR AVALIAÇAO FORA DOS PADROES DE 1 A 5
       // FakeDatabase fakeDatabase = new FakeDatabase();//instacia objeto com nome fakeDatabase da classe FakeDatabase
        //AtorService atorService = new AtorService(fakeDatabase);
        //String nome = "Will Smith";
        //LocalDate dataNascimento = LocalDate.of(1968, Month.SEPTEMBER, 25);
        //StatusCarreira statusCarreira = StatusCarreira.EM_ATIVIDADE;
       // Integer anoInicioAtividade = 1986;

        //comentario abaixo estava ativo ate Alencar desativar
        //ator request é para testar o primeiro ator will smith
       // AtorRequest atorRequest = new AtorRequest(nome, dataNascimento, statusCarreira, anoInicioAtividade);
        //comentario abaixo estava ativo ate Alencar desativar

        //atorService.criarAtor(atorService.getAtorRequest());//esta recebendo o return de Ator Service,
        // retun da variaveel atores da lista, e variavel atorRequest do metodo Getter

        //List<Ator> ators = fakeDatabase.recuperaAtores();
        //List<Ator> atores = atorService.criarAtor(atorService.getAtorRequest());
        //AtorService ator = new AtorService();

        //System.out.println("Deve conter 1 ator, quantidade encontrada: " + atores.size());
        //System.out.println("Primeiro ator deve ser 'Will Smith', valor encontrado: " + atores.get(0).getNome());//criei get nome em ator
        //System.out.println("Segundo ator deve ser 'Leonardo di Capri', valor encontrado: " + atores.get(1).getNome());//criei get nome em ator

   //}

//}