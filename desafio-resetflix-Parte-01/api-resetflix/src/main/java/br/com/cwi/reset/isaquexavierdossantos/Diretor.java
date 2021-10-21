package br.com.cwi.reset.isaquexavierdossantos;

import java.util.Date;

public class Diretor {
    private Integer id;
    private String nome;
    private Date dataNascimento;
    private Integer anoInicioAtividade;

    //método construtor de Diretor abaixo:
    public Diretor(Integer id, String nome, Date dataNascimento, Integer anoInicioAtividade) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.anoInicioAtividade = anoInicioAtividade;
    }
}
