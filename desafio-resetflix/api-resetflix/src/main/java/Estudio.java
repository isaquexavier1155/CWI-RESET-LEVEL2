public class Estudio {
    private Integer id;
    private String nome;
    private String descricao;
    private String dataCriacao;
    public enum StatusAtividade{
        
        EM_ATIVIDADE("Em Atividade"),
        ENCERRADO("Encerrado");

        private String statusAtividade;
        StatusAtividade(String statusAtividade) {
        }
        public String getStatusAtividade(){return statusAtividade;}
    }
}
