public class Diretor extends Pessoa {
    @Override
    public void imprimeDadosPessoa() {
        System.out.println("Nome Diretor: " + getNome());
        System.out.println("Idade Diretor: " + getIdade());
        System.out.println("Genero Diretor: " + getGenero());
    }

    private Integer quantidadeFilmes;

    public Diretor(String nome, Integer idade, Genero genero) {
        super(nome, idade, genero);
        this.quantidadeFilmes = quantidadeFilmes;
    }

}