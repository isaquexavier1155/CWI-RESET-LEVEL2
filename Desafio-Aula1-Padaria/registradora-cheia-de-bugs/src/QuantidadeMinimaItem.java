public class QuantidadeMinimaItem {

    public static boolean precisaReposicao(String item) {

        if (Constantes.PAO.equals(item)) {
            return ItensPorQuantidade.pao < Constantes.QTD_MINIMA_PAO;
        }

        if (Constantes.TORTA.equals(item)) {
            return ItensPorQuantidade.torta < Constantes.QTD_MINIMA_TORTA;
        }

        if (Constantes.SANDUICHE_PRONTO.equals(item)) {
            return ItensPorQuantidade.sanduiche == Constantes.QTD_MINIMA_SANDUICHE_PRONTO;
        }

        if (Constantes.CAFE.equals(item)) {
            return ItensPorQuantidade.leite < Constantes.QTD_MINIMA_CAFE;
        }

        if (Constantes.LEITE.equals(item)) {
            return ItensPorQuantidade.cafe < Constantes.QTD_MINIMA_LEITE;
        }

        return false;
    }

}
