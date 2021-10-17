package br.com.cwi.reset.isaquexavierdossantos;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Ator {
    //A classe Ator é um molde para os atores que vão ficar armazenados no seu programa.

    //criar id nas funcionalidades só atores e diretores, ler
    //nao tem regras de negocio para studio,filme e personagem ator, serao na proxima etapa

private Integer id;//id é numerico e sequencial. criar outro ator é o numero2 da listaprivate String nome;
private String nome;
private LocalDate dataNascimento;
private StatusCarreira statusCarreira;
private Integer anoInicioAtividade;



//método construtor de ator abaixo
    public Ator(Integer id, String nome, LocalDate dataNascimento, StatusCarreira statusCarreira, Integer anoInicioAtividade) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.statusCarreira = statusCarreira;
        this.anoInicioAtividade = anoInicioAtividade;


        if ((id)<=(anoInicioAtividade)) {
          // System.out.println("Erro, seu inicio de atividade esta anterior a sua data de nascimento");
        }
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");

        System.out.println("Data de hoje em numeros inteiros sem barra: "+Integer.parseInt(sdf.format(d)));
    }

    //criei metodo get nome do Ator para rodar a Aplicaçao.java
    public String getNome() {
        return nome;
    }



    //se faz sentido criar get e set
    //importante sao os nomes das propriedades, seguir regras de contrato

    public Integer getId() {
        return id;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public StatusCarreira getStatusCarreira() {
        return statusCarreira;
    }

    public Integer getAnoInicioAtividade() {
        return anoInicioAtividade;
    }


    }

