package br.com.cwi.reset.isaquexavierdossantos;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class AtorRequest {
   //se usa aquela classe AtorRequest pra simular essa requisição (vai simular uma DTO, um objeto que transfere dados).
   //na classe AtorService é onde recebe a request para criar o Ator, mas veja que no banco de dados ele recebe Ator e
   // não AtorRequest, dessa forma se usa o AtorService para transformar a classe de requisição na classe Ator


   //E por fim, AtorRequest é a classe que você vai usar como entrada pra criar um ator.
   // Percebeu que "Ator" tem um atributo a mais que "AtorRequest"?
   // Há situações nas quais quem está usando o programa não vai inserir manualmente
   // todas as características que aquele objeto realmente tem.
   // Neste caso, por exemplo, um ID pode ser atribuído automaticamente em vez de ser um
   // campo pro qual você tem que definir um valor ao criar um ator.

   private String nome;
   private LocalDate dataNascimento;
   private StatusCarreira statusCarreira;//variavel status carreira recebe dados dA Classe StatusCarreira
   private Integer anoInicioAtividade;

   //nao tenho certeza linha dee baixo
  // private AtorRequest atorRequest;

   public AtorRequest(String nome, LocalDate dataNascimento, StatusCarreira statusCarreira, Integer anoInicioAtividade) {
      this.nome = nome;
      this.dataNascimento = dataNascimento;
      this.statusCarreira = statusCarreira;
      this.anoInicioAtividade = anoInicioAtividade;
   }

   }

