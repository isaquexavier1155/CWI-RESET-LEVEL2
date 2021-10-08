
public class Registradora {

    public static void main(String[] args) {

       primeiroBug();

       segundoBug();

       terceiroBug();

       quartoBug();

       quintoBug();

       sextoBug();
    }

    private static double registrarItem(String item, int quantidade) {
        //Reposição padrão por quantidade mínima
        if (QuantidadeMinimaItem.precisaReposicao(item)) {
            ReposicaoItem.reporItem(item);
        }

        boolean itemDependeDeCozinha = Constantes.PAO.equals(item) || Constantes.SANDUICHE_PRONTO.equals(item) || Constantes.TORTA.equals(item);
        boolean cozinhaFechada = !DataProjeto.cozinhaEmFuncionamento();
        boolean estoqueInsuficiente = ItensPorQuantidade.estoqueInsuficiente(item, quantidade);

        if (itemDependeDeCozinha && cozinhaFechada && estoqueInsuficiente) {
            System.out.println("Cozinha fechada!");
            String mensagemFormatada = String.format("Reposição indisponível de %s, quantidade restante em estoque é de %d.", item, ItensPorQuantidade.pegarEstoqueItem(item));
            System.out.println(mensagemFormatada);
            throw new RuntimeException("Somente para encerrar a execução do programa!");
        } else {
            //Reposição padrão por falta de estoque para a venda
            while (ItensPorQuantidade.estoqueInsuficiente(item, quantidade)) {
                ReposicaoItem.reporItem(item);
            }
        }

        return RelacaoPesoPreco.retornaPrecoProduto(item, quantidade);
    }

    private static void primeiroBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = Constantes.SANDUICHE_PRONTO;
        int quantidade = 4;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void segundoBug() {
        DataProjeto.criarDataComCozinhaEncerradaMasComDiaUtil();
        String item = Constantes.TORTA;
        int quantidade = 10;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void terceiroBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = Constantes.CAFE;
        int quantidade = 40;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void quartoBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        // Cliente 1
        String item = Constantes.SANDUICHE_PRONTO;
        int quantidade = 20;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));

        // Cliente 2
        String item2 = Constantes.SANDUICHE_PRONTO;
        int quantidade2 = 5;

        double precoTotal2 = registrarItem(item2, quantidade2);

        System.out.println(String.format("Valor total: %.2f", precoTotal2));
    }

    private static void quintoBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = Constantes.PAO;
        int quantidade = 10;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void sextoBug() {
        DataProjeto.criarDataComCozinhaEncerradaSemDiaUtil();
        // Cliente 1
        String item = Constantes.SANDUICHE_PRONTO;
        int quantidade = 20;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));

        // Cliente 2
        String item2 = Constantes.SANDUICHE_PRONTO;
        int quantidade2 = 5;

        double precoTotal2 = registrarItem(item2, quantidade2);

        System.out.println(String.format("Valor total: %.2f", precoTotal2));
    }

}