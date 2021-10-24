package br.com.cwi.reset.isaquexavierdossantos.request;

import br.com.cwi.reset.isaquexavierdossantos.model.StatusCarreira;
import org.apache.logging.log4j.message.Message;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

public class AtorRequest {
    @NotNull(message= "Campo obrigatório nao informado. Favor Informar o campo nome.")
    //aqui vai outros Beans validations-link de outros no readme do desafio Resetflix parte 3
    // So usar aqui os que o usuario vai ver nao todos que so o sistema precisa saber
    // exeplo: senaome existe, nao precisa ser incluido aqui.
    //usar beans notnull e outros para campos nulos, invalido
    private String nome;

    @NotNull(message= "Campo obrigatório nao informado. Favor Informar o campo dataNascimento.")
    @Past(message = "Futuro nao aceito, excecao criada dentro de AtorRequest")
    private LocalDate dataNascimento;

    @NotNull(message= "Campo obrigatório nao informado. Favor Informar o campo statusCarreira.")
    private StatusCarreira statusCarreira;

    @NotNull(message= "Campo obrigatório nao informado. Favor Informar o campo anoInicioAtividade.")
    private Integer anoInicioAtividade;

    public AtorRequest(String nome, LocalDate dataNascimento, StatusCarreira statusCarreira, Integer anoInicioAtividade) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.statusCarreira = statusCarreira;
        this.anoInicioAtividade = anoInicioAtividade;
    }

    public String getNome() {
        return nome;
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
