public class Pessoa {
    private String nome;
    private Integer idade;
    private Genero genero;

    public Pessoa(String nome, Integer idade,Genero genero ) {
        this.nome = nome;
        this.idade = idade;
        this.genero=genero;
    }

    public void imprimeDadosPessoa(){
        System.out.println("Nome Ator: " + nome);
        System.out.println("Idade Ator: " + idade);
        System.out.println("Genero Ator: " + genero);
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public Genero getGenero() {
        return genero;
    }
}
