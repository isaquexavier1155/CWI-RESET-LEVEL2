package br.com.cwi.reset.isaquexavierdossantos.controller;

import br.com.cwi.reset.isaquexavierdossantos.FakeDatabase;
import br.com.cwi.reset.isaquexavierdossantos.exception.*;
import br.com.cwi.reset.isaquexavierdossantos.model.Ator;
import br.com.cwi.reset.isaquexavierdossantos.model.StatusCarreira;
import br.com.cwi.reset.isaquexavierdossantos.request.AtorRequest;
import br.com.cwi.reset.isaquexavierdossantos.response.AtorEmAtividade;
import br.com.cwi.reset.isaquexavierdossantos.service.AtorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

//import static br.com.cwi.reset.isaquexavierdossantos.FakeDatabase.fakeDatabase;

@RestController//@RestController: Aqui dizemos para o Spring que nossa classe é uma "Controladora"
// , ou seja, é ela que irá mapear quais Endpoints iremos disponibilizar na
// nossa aplicação, e como eles se comportam. També é aqui que identificamos dados que
// recebemos pela request, informações que iremos responder, método http utilizado, headers trafegados, etc.
@RequestMapping("/atores")//Utilizando uma dessas anotações em um método de uma Controller do Spring
// estamos especificando qual método/verbo HTTP é utilizado. exe get, post, delete

public class AtorController {

    private AtorService atorService;//refereneciar a ator service pois e nela que esta a regra de negocio e enao vamos mecher
    private FakeDatabase fakeDatabase;

    //construtor abaixo:
    public AtorController() {
        this.atorService = new AtorService(FakeDatabase.getInstance());//criar nova instancia de ator service que recebe fakdatabase ja inicializada
    }//.getInstance= ja pega a instancia de database ja inicializado, para deixar todos os dados no fackdatabase e achar quando for criar um filme ou algo assim

    //demais métodos
    @PostMapping//assinatura
    @ResponseStatus(HttpStatus.CREATED)//aqui escolhe o tipo de erro ou resposta exemplo:
    // 200, 400, se nao tiver nada é padrao retornar 200, entao cuidar falso 200
    //  @ResponseStatus.aqui depois do ponto escolhe outros retornos ex 400

    public void criarAtor(@RequestBody @Valid AtorRequest atorRequest) throws Exception {//Exception só joga pra cima, por que ela ja vai vim com a notcao para o spring tratar
        this.atorService.criarAtor(atorRequest);
        //@Valid acima é pra aceitar os Beans Validations da Classe Ator Request @NotNull
        //recebe ator request  e chama a service passando ator
        //@RequestBody: Aqui estamos dizendo que recebemos tal parâmetro no corpo da requisição.
        // Obs: Métodos GET e DELETE não possuem corpo em suas requests.

    }

    @GetMapping//consul
    public List<Ator> consultarAtores() throws Exception {//aqui deu certo nao alterar
        final List<Ator> atores = atorService.consultarAtores();
       return atores;//retorna todos os atores cadastrdos
    }

    @GetMapping(path = "/em_atividade")
    public List<AtorEmAtividade> listarAtoresEmAtividade(String filtroNome) throws Exception {
        final List<Ator> atoresCadastrados = atorService.consultarAtores();//Troquei o ator database por ator service e o metodo

        if (atoresCadastrados.isEmpty()) {
            throw new ListaVaziaException(TipoDominioException.ATOR.getSingular(), TipoDominioException.ATOR.getPlural());
        }

        final List<AtorEmAtividade> retorno = new ArrayList<>();

        if (filtroNome != null) {
            for (Ator ator : atoresCadastrados) {
                final boolean containsFilter = ator.getNome().toLowerCase(Locale.ROOT).contains(filtroNome.toLowerCase(Locale.ROOT));
                final boolean emAtividade = StatusCarreira.EM_ATIVIDADE.equals(ator.getStatusCarreira());
                if (containsFilter && emAtividade) {
                    retorno.add(new AtorEmAtividade(ator.getId(), ator.getNome(), ator.getDataNascimento()));
                }
            }
        } else {
            for (Ator ator : atoresCadastrados) {
                final boolean emAtividade = StatusCarreira.EM_ATIVIDADE.equals(ator.getStatusCarreira());
                if (emAtividade) {
                    retorno.add(new AtorEmAtividade(ator.getId(), ator.getNome(), ator.getDataNascimento()));
                }
            }
        }

        if (retorno.isEmpty()) {
            throw new FiltroNomeNaoEncontrado("Ator", filtroNome);
        }

        return retorno;//Metodo Consulatar atores esta filtrando por Status Atividade em Atividade, ok
    }

    @GetMapping("{id}")
    public Ator consultarAtor(@PathVariable Integer id) throws Exception {

        if (id == null) {
            throw new IdNaoInformado();
        }

        final List<Ator> atores = atorService.consultarAtores();//troquei fake database por ator service e metodo

        for (Ator ator : atores) {
            if (ator.getId().equals(id)) {
                return ator;
            }
        }

        throw new ConsultaIdInvalidoException(TipoDominioException.ATOR.getSingular(), id);
    }


   // public List<Ator>listarAtoresEmAtividade(String a){
     //   final List<Ator> atores = atorService.listarAtoresEmAtividade();

   // }


}//fecha classe principal


// Retorno: List< AtorEmAtividade > | Método: listarAtoresEmAtividade(String filtroNome)
   // private static List<Ator> atorrin = new ArrayList<>();

  //  @GetMapping("/{nome}")
    //public List<Ator> listarAtoresEmAtividade(@PathVariable String nome) {
//return listarAtoresEmAtividade(nome);
   // }
//}
        //return null;

    //retornou o numero 1 pode ser falso retorno


      // atores.add(atorRequest);
      //  return ResponseEntity.ok(atorRequest);

   // @RequestMapping("/atores/em_atividade")

   // @GetMapping("/{em_atividade}")
   // public StatusAtividade listarAtoresEmAtividade(@PathVariable String em_atividade) {
       // return listarAtoresEmAtividade(em_atividade);
   // }

   // @GetMapping
    //public List<Ator> consultarTodos() {
       // return atores;
    //}

//}
    //ao criar os metodos cuidar as saidas status para ver oq pede
    //criou esse metodo abaixo e apagou deve ser por esse caminho
    //metodo listar atores
   // public List<Ator> consultarAtores(){
     //   this.atorService.consultarAtores()
    //}
