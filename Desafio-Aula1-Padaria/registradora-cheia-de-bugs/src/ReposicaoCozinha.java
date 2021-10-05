public class ReposicaoCozinha {

    static void reporItem(String item) {
        if ("paes".equals(item)) {
            ItensPorQuantidade.pao = 3600;
        }
        if ("torta".equals(item)) {
            ItensPorQuantidade.torta = 4;//Quando o estoque de tortas estiver menor do que 10 fatias, a linha de produção sempre prepara 4 tortas
        }
        if ("sanduiche".equals(item)) {
            ItensPorQuantidade.sanduiche = 20;
        }
    }
}
