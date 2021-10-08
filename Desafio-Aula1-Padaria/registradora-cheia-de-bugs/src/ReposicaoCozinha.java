public class ReposicaoCozinha {

    static void reporItem(String item) {

            if (Constantes.PAO.equals(item)) {
                ItensPorQuantidade.pao = ItensPorQuantidade.pao + Constantes.QTD_PADRAO_PAO;
            }
            if (Constantes.TORTA.equals(item)) {
                ItensPorQuantidade.torta = ItensPorQuantidade.torta + Constantes.QTD_PADRAO_TORTA;
                //Quando o estoque de tortas estiver menor do que 10 fatias, a linha de produção sempre prepara 4 tortas
            }
            if (Constantes.SANDUICHE_PRONTO.equals(item)) {
                ItensPorQuantidade.sanduiche = ItensPorQuantidade.sanduiche + Constantes.QTD_PADRAO_SANDUICHE_PRONTO;
                //Quando houver apenas uma unidade de sanduíche pronto disponível,
                //a linha de produção sempre prepara 20 novos sanduíches prontos

            }
        }
    }


