public class Ator {
    private String nome;
    private Integer idade;
    private Integer oscarVencidos;
    private Genero genero;


    public void dadosAtor(){
        System.out.println("Nome Ator: " + nome);
        System.out.println("Idade Ator: " + idade);
        System.out.println("Genero Ator: " + genero);


    }
    public Ator(String nome, Integer idade, Genero genero) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
    }

}
