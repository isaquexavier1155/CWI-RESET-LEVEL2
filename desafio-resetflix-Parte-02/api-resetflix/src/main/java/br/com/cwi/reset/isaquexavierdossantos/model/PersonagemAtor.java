package br.com.cwi.reset.isaquexavierdossantos.model;

public class PersonagemAtor {
    private Integer id;
    private Ator ator;
    private String nomePersonagem;
    private String descricaoPersonagem;
    private TipoAtuacao tipoAtuacao;

    public PersonagemAtor(Integer id, Ator ator, String nomePersonagem, String descricaoPersonagem, TipoAtuacao tipoAtuacao) {
        this.id = id;
        this.ator = ator;
        this.nomePersonagem = nomePersonagem;
        this.descricaoPersonagem = descricaoPersonagem;
        this.tipoAtuacao = tipoAtuacao;
    }

    public Integer getId() {
        return id;
    }

    public Ator getAtor() {
        return ator;
    }

    public String getNomePersonagem() {
        return nomePersonagem;
    }

    public String getDescricaoPersonagem() {
        return descricaoPersonagem;
    }

    public TipoAtuacao getTipoAtuacao() {
        return tipoAtuacao;
    }
}
