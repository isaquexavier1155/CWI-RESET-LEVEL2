public class ItensPorQuantidade {

    static int pao = Constantes.QTD_PADRAO_PAO;
    static int torta = Constantes.QTD_PADRAO_PAO;
    static int sanduiche = Constantes.QTD_PADRAO_SANDUICHE_PRONTO;
    static int leite = 20;
    static int cafe = 20;


    public static boolean estoqueInsuficiente(String item, int quantidade) {
        if (Constantes.CAFE.equals(item)) {
            return quantidade > ItensPorQuantidade.cafe;
        }

        if (Constantes.LEITE.equals(item)) {
            return quantidade > ItensPorQuantidade.leite;
        }

        if (Constantes.TORTA.equals(item)) {
            return quantidade > ItensPorQuantidade.torta;
        }

        if (Constantes.SANDUICHE_PRONTO.equals(item)) {
            return quantidade > ItensPorQuantidade.sanduiche;
        }

        if (Constantes.PAO.equals(item)) {
            return quantidade > ItensPorQuantidade.pao;
        }

        return false;
    }

    public static int pegarEstoqueItem(String item) {
        if (Constantes.CAFE.equals(item)) {
            return ItensPorQuantidade.cafe;
        }

        if (Constantes.LEITE.equals(item)) {
            return ItensPorQuantidade.leite;
        }

        if (Constantes.TORTA.equals(item)) {
            return ItensPorQuantidade.torta;
        }

        if (Constantes.SANDUICHE_PRONTO.equals(item)) {
            return ItensPorQuantidade.sanduiche;
        }

        if (Constantes.PAO.equals(item)) {
            return ItensPorQuantidade.pao;
        }

        throw new RuntimeException("Este caso não deveria existir!");
    }

}
