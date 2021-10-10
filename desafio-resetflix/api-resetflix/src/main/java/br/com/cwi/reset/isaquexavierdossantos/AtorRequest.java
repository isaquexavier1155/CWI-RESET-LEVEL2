package br.com.cwi.reset.isaquexavierdossantos;

import java.time.LocalDate;

public class AtorRequest {
   private String nome;
   private LocalDate dataNascimento;
   private StatusCarreira statusCarreira;//variavel status carreira recebe dados dA Classe StatusCarreira
   private Integer anoInicioAtividade;

   public AtorRequest(String nome, LocalDate dataNascimento, StatusCarreira statusCarreira, Integer anoInicioAtividade) {
      this.nome = nome;
      this.dataNascimento = dataNascimento;
      this.statusCarreira = statusCarreira;
      this.anoInicioAtividade = anoInicioAtividade;
   }

   //adicionei essa linhas abaixo para enviar dados para a classe AtorService

   //public void criarAtor(AtorRequest atorRequest){


/*this.("Isaque");
this.setAnoInicioAtividade(2000);
this.setId(1111111);
this.setStatusCarreira(StatusCarreira.EM_ATIVIDADE);*/

   //}
   //private String atorRequest;

   //public String getAtorRequest(){return atorRequest;}
}
