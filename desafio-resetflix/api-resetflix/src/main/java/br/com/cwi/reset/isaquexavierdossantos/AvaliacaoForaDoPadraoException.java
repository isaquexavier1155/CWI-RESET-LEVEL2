package br.com.cwi.reset.isaquexavierdossantos;
// //EXCECAO 1 CRIAR PRIMEIRO ESSA
public class AvaliacaoForaDoPadraoException extends Exception{
    public AvaliacaoForaDoPadraoException() {
        super("Campo obrigatório não informado. Favor informar o campo {campo}");
    }
}
