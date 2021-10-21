package br.com.cwi.reset.josealencar.model;

import java.util.List;

public class Filme {

    private Integer id;
    private String nome;
    private Integer anoLancamento;
    private String capaFilme;
    private List<Genero> generos;
    private Estudio estudio;
    private Diretor diretor;
    private List<PersonagemAtor> personagens;
    private String resumo;

    public Filme(Integer id, String nome, Integer anoLancamento, String capaFilme, List<Genero> generos, Estudio estudio, Diretor diretor, List<PersonagemAtor> personagens, String resumo) {
        this.id = id;
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.capaFilme = capaFilme;
        this.generos = generos;
        this.estudio = estudio;
        this.diretor = diretor;
        this.personagens = personagens;
        this.resumo = resumo;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public String getCapaFilme() {
        return capaFilme;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public Estudio getEstudio() {
        return estudio;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public List<PersonagemAtor> getPersonagens() {
        return personagens;
    }

    public String getResumo() {
        return resumo;
    }
}
