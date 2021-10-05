public class RelacaoPesoPreco {

    public static double retornaPrecoProduto(String item, int qtd) {
        double precoTotal = 0;

        if ("pao".equals(item)) {
            precoTotal = 12.75 * (qtd * 60 / 1000);
        }

        //if ("torta".equals(item)) {
        //  precoTotal = 96.00 * (qtd / 16);
        //}
        if("torta".equals(item)){//correçao do bug 2 realizado com sucesso, alterei a classe relaçao peso preco, adicionei calculo fatia de torta
            precoTotal = 6.00 * qtd;
        }

        if ("leite".equals(item)) {
            precoTotal = 4.48 * qtd;
        }

        if ("cafe".equals(item)) {
            precoTotal = 9.56 * qtd;
        }

        if ("sanduiche".equals(item)) { //alteraçao de sanduba para sanduiche
            precoTotal = 4.5 * qtd;
        }

        return precoTotal;
    }
}
