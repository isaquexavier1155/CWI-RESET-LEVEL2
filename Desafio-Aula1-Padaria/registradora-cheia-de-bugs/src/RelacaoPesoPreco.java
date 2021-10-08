public class RelacaoPesoPreco {

    public static double retornaPrecoProduto(String item, int qtd) {
        double precoTotal = 0;

        if (Constantes.PAO.equals(item)) {
            precoTotal = 12.75 * qtd * 60 / 1000;
            ItensPorQuantidade.pao = ItensPorQuantidade.pao - (qtd * 60);
        }

        if (Constantes.TORTA.equals(item)) {
            precoTotal = 96.00 * qtd / 16;
            ItensPorQuantidade.torta = ItensPorQuantidade.torta - qtd;
        }

        if (Constantes.LEITE.equals(item)) {
            precoTotal = 4.48 * qtd;
            ItensPorQuantidade.leite = ItensPorQuantidade.leite - qtd;
        }

        if (Constantes.CAFE.equals(item)) {
            precoTotal = 9.56 * qtd;
            ItensPorQuantidade.cafe = ItensPorQuantidade.cafe - qtd;
        }

        if (Constantes.SANDUICHE_PRONTO.equals(item)) {
            precoTotal = 4.5 * qtd;
            ItensPorQuantidade.sanduiche = ItensPorQuantidade.sanduiche - qtd;
        }

        return precoTotal;
    }
}