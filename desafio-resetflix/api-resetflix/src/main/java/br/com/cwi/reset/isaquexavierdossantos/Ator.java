package br.com.cwi.reset.isaquexavierdossantos;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
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
    public Ator(Integer id, String nome, LocalDate dataNascimento, StatusCarreira statusCarreira, Integer anoInicioAtividade) throws AvaliacaoForaDoPadraoException {
        //Criei essa regra de ecessaoo

        if (anoInicioAtividade < 1800) {
            //EXCECAO 2 Criar segunda exception
            throw new AvaliacaoForaDoPadraoException();
            //SE AVALIACAO COLOCADA FICAR FORA DOS PADROES DA ERRRO NO CÓDIGO, ATIVA CLASSE AvaliacaoForaDoPadraoException
        }
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.statusCarreira = statusCarreira;
        this.anoInicioAtividade = anoInicioAtividade;
    }

    //criei metodo get nome do Ator para rodar a Aplicaçao.java
    public String getNome() {
        return nome;
    }



    //se faz sentido criar get e set
    //importante sao os nomes das propriedades, seguir regras de contrato




    }

