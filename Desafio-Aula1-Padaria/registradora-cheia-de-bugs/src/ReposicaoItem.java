public class ReposicaoItem {
    public static void reporItem(String item) {
        if (Constantes.PAO.equals(item) || Constantes.SANDUICHE_PRONTO.equals(item) || Constantes.TORTA.equals(item)) {
            ReposicaoCozinha.reporItem(item);
        }

        if (Constantes.LEITE.equals(item) || Constantes.CAFE.equals(item)) {
            ReposicaoFornecedor.reporItem(item);
        }
    }
}
