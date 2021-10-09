public enum Genero {
    MASCULINO("Masculino"),
    FEMININO("Femia"),
    NAO_BINARIO("Nao binario");

    private String descricao;

    Genero(String descricao){
        this.descricao= descricao;
    }

    public String getDescricao(){ return descricao;}
}
