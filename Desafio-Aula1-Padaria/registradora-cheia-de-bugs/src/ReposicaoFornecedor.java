import java.util.Random;

public class ReposicaoFornecedor {

    static void reporItem(String item) {
        Random random = new Random();

        if (Constantes.LEITE.equals(item)) {
            ItensPorQuantidade.leite = ItensPorQuantidade.leite + random.nextInt(40) + 10;
        }

        if (Constantes.CAFE.equals(item)) {
            ItensPorQuantidade.cafe = ItensPorQuantidade.cafe + random.nextInt(40) + 10;
        }
    }
}
