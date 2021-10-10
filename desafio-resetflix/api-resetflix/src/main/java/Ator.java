import java.util.Date;

public class Ator {
private Integer id;
private String nome;
private Date dataNascimento;

public enum StatusCarreira{

    EM_ATIVIDADE("Em atividade"),
    APOSENTADO("Aposentado");

    private String statusCarreira;

    StatusCarreira(String statusCarreira){

    }
    public String getStatusCarreira(){return statusCarreira;}
}
}
