package br.com.cwi.reset.isaquexavierdossantos.controller;

import br.com.cwi.reset.isaquexavierdossantos.FakeDatabase;
import br.com.cwi.reset.isaquexavierdossantos.model.Ator;
import br.com.cwi.reset.isaquexavierdossantos.request.AtorRequest;
import br.com.cwi.reset.isaquexavierdossantos.service.AtorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/atores")
public class AtorController {

    private AtorService atorService;//refereneciar a ator service pois e nela que esta a regra de negocio e enao vamos mecher

    //construtor abaixo:
    public AtorController() {
        this.atorService = new AtorService(FakeDatabase.getInstance());//criar nova instancia de ator service que recebe fakdatabase ja inicializada
    }//.getInstance= ja pega a instancia de database ja inicializado, para deixar todos os dados no fackdatabase e achar quando for criar um filme ou algo assim

    //demais métodos
    @PostMapping//assinatura
    @ResponseStatus(HttpStatus.CREATED)//aqui escolhe o tipo de erro ou resposta exemplo:
    // 200, 400, se nao tiver nada é padrao retornar 200, entao cuidar falso 200
    //  @ResponseStatus.aqui depois do ponto escolhe outros retornos ex 400

    public void criarAtor(@RequestBody AtorRequest atorRequest) throws Exception {//Exception só
        // joga pra cima, por que ela ja vai vim com a notcao para o spring tratar
        this.atorService.criarAtor(atorRequest);//recebe ator request e chama a service passando ator
    }
    //ao criar os metodos cuidar as saidas status para ver oq pede
    //criou esse metodo abaixo e apagou deve ser por esse caminho
    //metodo listar atores
   // public List<Ator> consultarAtores(){
     //   this.atorService.consultarAtores()
    //}
}