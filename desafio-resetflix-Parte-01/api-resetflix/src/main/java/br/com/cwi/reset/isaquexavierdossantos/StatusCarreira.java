package br.com.cwi.reset.isaquexavierdossantos;

public enum StatusCarreira {

    EM_ATIVIDADE("Em atividade"),
    APOSENTADO("Aposentado");

    private String statusCarreira;

    StatusCarreira(String statusCarreira){//construtor

    }
    //return
    public String getStatusCarreira(){return statusCarreira;}
}
