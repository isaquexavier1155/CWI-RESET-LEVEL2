public class Diretor {
    private String nome;
    private Integer idade;
    private Integer quantidadeFilmes;
    private Genero genero;

    public Diretor(String nome, Integer idade, Integer quantidadeFilmes) {
        this.nome = nome;
        this.idade = idade;
        this.quantidadeFilmes = quantidadeFilmes;
    }

    public String getNome() {
        return nome;
    }

    public void dadosDiretor(){
        System.out.println("Nome Diretor: " + nome);
        System.out.println("Idade Diretor: " + idade);
        System.out.println("Genero Diretor: " + genero);

    }

    public Diretor(String nome, Integer idade, Genero genero) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
    }
}