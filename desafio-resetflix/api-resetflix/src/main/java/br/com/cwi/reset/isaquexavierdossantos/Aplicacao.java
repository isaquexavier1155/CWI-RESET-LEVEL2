package br.com.cwi.reset.isaquexavierdossantos;

import java.time.LocalDate;
import java.time.Month;//importei essa classe por conta
import java.util.ArrayList;
import java.util.List;

public class Aplicacao {

    public static void main(String[] args) {
        FakeDatabase fakeDatabase = new FakeDatabase();//instacia objeto com nome fakeDatabase da classe FakeDatabase

        //List<Ator> atorss = new ArrayList<>();
        //atorss.addAll

        AtorService atorService = new AtorService(fakeDatabase);
        String nome = "Will Smith";
        LocalDate dataNascimento = LocalDate.of(1968, Month.SEPTEMBER, 25);
        StatusCarreira statusCarreira = StatusCarreira.EM_ATIVIDADE;
        Integer anoInicioAtividade = 1986;

       // Ator ator1 = new Ator("ISAQUE",LocalDate.of(1993, Month.DECEMBER, 10),statusCarreira.EM_ATIVIDADE, 2009);
        Ator ator1 = new Ator(01,"Will Smith",LocalDate.of(1968, Month.SEPTEMBER, 25),statusCarreira.EM_ATIVIDADE,1986);
        Ator ator2 = new Ator(02,"Leonardo di Capri",LocalDate.of(1975, Month.APRIL, 12),statusCarreira.EM_ATIVIDADE,1997);

        //comentario abaixo estava ativo ate Alencar desativar
        //ator request é para testar o primeiro ator will smith
        AtorRequest atorRequest = new AtorRequest(nome, dataNascimento, statusCarreira, anoInicioAtividade);
        //comentario abaixo estava ativo ate Alencar desativar
        atorService.criarAtor(atorRequest);//nao esta recebendo nada pois variavel

        List<Ator> atores = fakeDatabase.recuperaAtores();
        atores.add(ator1);//Consegui fazer receber uma lista mas dessa mesma classe, fazer agora receber de outra
        atores.add(ator2);

       /* System.out.println("atores: "+atores);
        System.out.println("atorRequest: "+atorRequest);
        System.out.println("nome: "+nome);
        System.out.println("ator service: "+atorService);*/

        System.out.println("Deve conter 1 ator, quantidade encontrada: " + atores.size());
        System.out.println("Primeiro ator deve ser 'Will Smith', valor encontrado: " + atores.get(0).getNome());//criei get nome em ator
        System.out.println("Segundo ator deve ser 'Leonardo di Capri', valor encontrado: " + atores.get(1).getNome());//criei get nome em ator

    }

}