public class QuantidadeMinimaItem {

    public static boolean precisaReposicao(String item) {
        if ("pao".equals(item)) {//aleterei palavra paes para pao
            return ItensPorQuantidade.pao < 600;//Quando o estoque disponível for menor que 600 gramas, a linha de
           // produção sempre prepara 3,6 quilogramas

        }

        if ("torta".equals(item)) {
            return ItensPorQuantidade.torta < 10;//Quando o estoque de tortas estiver menor do que 10 fatias,
            // a linha de produção sempre prepara 4 tortas
        }

        if ("sanduiche".equals(item)) {//alterçao de sanduba para sanduiche
            return ItensPorQuantidade.sanduiche == 1;//uma unidade de sanduíche pronto disponível,a linha
            // de produção sempre prepara 20 novos sanduíches prontos
        }

        if ("leite".equals(item)) {
            return ItensPorQuantidade.leite < 12;//alterei a posicao de cafe em relaçao a leite
        }
        //aqui observaar a questao do estoque disponivel
        //Para o café e o leite, deve ser enviado uma ordem para meu fornecedor
        //realizar a reposição, o número de itens para reposição pode variar entre 10 e
        //50, dependendo da disponibilidade do fornecedor, e a reposição do item deve
        //ser solicitada sempre que a quantidade em estoque for menor que uma dúzia

        if ("cafe".equals(item)) {
            return ItensPorQuantidade.cafe < 12;//alterei a posicao de cafe em relaçao a leite
        }

        return false;
    }
}
