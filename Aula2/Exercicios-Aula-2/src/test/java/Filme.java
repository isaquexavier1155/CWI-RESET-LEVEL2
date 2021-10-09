public class Filme {
    private String nome;
    private String descricao;
    private Integer duracao;
    private Integer anoLancamento;
    private Double avaliacao;
    private String diretor;

    public Filme(String nome, String descricao, Integer duracao, Integer anoLancamento, Double avaliacao, String diretor) throws AvaliacaoForaDoPadraoException {
        if (avaliacao < 1 || avaliacao > 5) {
            throw new AvaliacaoForaDoPadraoException();
            //SE AVALIACAO COLOCADA FICAR FORA DOS PADROES DA ERRRO NO CÓDIGO, ATIVA CLASSE AvaliacaoForaDoPadraoException
        }
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.anoLancamento = anoLancamento;
        this.avaliacao = avaliacao;
        this.diretor = diretor;
    }

    public void reproduzir() {
        System.out.println("Nome Filme: " + nome);
        System.out.println("Descriçao: " + descricao);
        System.out.println("Duração: " + duracao);
        System.out.println("Ano Lançamento: " + anoLancamento);
        System.out.println("Avaliaçao: " + avaliacao);
        System.out.println("Diretor: " + diretor);

    }

}