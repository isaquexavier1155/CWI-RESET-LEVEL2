package br.com.cwi.reset.projeto1;

//import sun.jvm.hotspot.types.CIntegerField;

import java.util.Arrays;
import java.util.List;

public class Exercicios1 {


    public Integer somarLista(List<Integer> numeros) {

        int soma = 0;
        for (int num : numeros) {//um tipo e um array, percorre todos os itens do array numeros
            soma += num;//soma numeros do array com o proximo array ate zerar
        }

        return soma;
    }

    public Double calcularMedia(List<Integer> numeros) {
        double somaMedia = 0;
        int somaValor = 0;
        for (int somaArray : numeros) {
            somaValor += somaArray;
        }
        somaMedia = somaValor / numeros.toArray().length;

        return somaMedia;
    }


    public Integer obterMaiorNumero(List<Integer> numeros) {
        int comparacao = numeros.get(0);


        for (int percorreArray : numeros) {

            if (percorreArray > comparacao) {

                comparacao = percorreArray;
            }

        }

        return comparacao;
    }

    public String obterPalavraInvertida(String palavra) {
        String invertendo = "";
        for (int i = palavra.length() - 1; i >= 0; i--) {
            invertendo += palavra.charAt(i);
        }

        return invertendo;
    }

    public List<Integer> ordenarLista(List<Integer> numeros) {
        Integer[] numVetor = new Integer[6];//criacao do array,matriz,de nome numVetor, com 6 celulas
        numVetor = numeros.toArray(new Integer[numeros.size()]);//converte numeros da lista em array
        int recebeMudancas;//criacao de variavel que recebera cada mudanca
        for (int i = 0; i < numeros.size() - 1; i++) {//inicio da iteracao para fazer as trocas de posicao no array,
            // compara carta anterior com a proxima carta do array, primeira carta assume o ultimo lugar
            for (int j = i + 1; j < numeros.size(); j++) {//inicio do bubble sort, compara cada carta e se for maior troca
                if (numVetor[j] < numVetor[i]) {
                    recebeMudancas = numVetor[j];
                    numVetor[j] = numVetor[i];
                    numVetor[i] = recebeMudancas;//recebe mudancas a cada ciclo
                }
            }
        }
        return Arrays.asList(numVetor);//converte array em lista e manda para a classe TesteExercicios.java

    }


}

         //----------------->TENTATIVAS DE CODIGO<-------------------

        //int[] arrayNumero = {29, 78, 8, 56, 15, 466};
        //int[] arrayNumero= new int[6];
        //int comparacao = numeros.get(0);

       // Arrays.sort(arrayNumero);//verifica cada array e organiza em ordem crescente
      //  for (int i = 0; i < arrayNumero.length; i++) {

      //  }
    //    int[] vet = new int[6];
      //  int aux = 0;
        //int i = 0;

     //   System.out.println("Vetor desordenado: ");
   //     for(i = 0; i<5; i++){
      //      System.out.println(" "+vet[i]);
   //     }
     //   System.out.println(" ");
//
  //      for(i = 0; i<5; i++){
    //        for(int j =i+1; j<4; j++){
      //          if(vet[j] > vet[j + 1]){
        //            aux = vet[j];
          //          vet[j] = vet[j+1];
              //      vet[j+1] = aux;
            //    }
          //  }
        //}

  //      System.out.println("Vetor organizado:");
    //    for(i = 0; i<5; i++) {
      //      System.out.println(" " + vet[i]);
        //}

     //   return Arrays.asList(vet[i]);
        //System.out.println(" vet"+vet[i]);



       // return Arrays.asList(arrayNumero[0]);
        //convertendo o array para lista
   // }

//}

       // Integer[] salvamenoresNumeros = new Integer[7];
        //salvamenoresNumeros[0]=10;
        //List<Integer> salvaNum = new ArrayList<>();
        //Integer[] salvaNum = new Integer[7];
        //Integer[] salvaNum= {10, 1564, 200, 15, 12, 144};
        //for (int i = 0; i<= salvaNum.length-1; i++) {
        //  for (int j = 0; j <= salvaNum.length - 1 - i; j++){
        //      if (salvaNum[j] > salvaNum[j + 1]){
        //          int aux = salvaNum[j];
        //          salvaNum[j] = salvaNum[j + 1];
        //          salvaNum[j + 1] = aux;
        //      }
        //
        // }
        // }
        //int comparacao = 0;
       // comparacao=salvaNum;
//return Arrays.asList(salvaNum[7]);//precido retornar uma matrix de inteiros


           // int comparacao = numeros.get(0);//daqui pra baixo pegou certinho o menor numero existente na matriz nmumeros
        // for (int percorreArray : numeros) {

        //  if (percorreArray < comparacao) {

        //       comparacao = percorreArray;
        //      }

            //}

//consegui fazer aparecer o menor valor de dentro da matrix numeros
        //achar uma maneira de criar uma matrix e ir adicionando esses menores numeros em cada indice em cada iteracao


//  }
//}

