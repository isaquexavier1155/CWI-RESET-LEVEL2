package br.com.cwi.reset.isaquexavierdossantos.controller;

import br.com.cwi.reset.isaquexavierdossantos.FakeDatabase;
import br.com.cwi.reset.isaquexavierdossantos.model.Filme;
import br.com.cwi.reset.isaquexavierdossantos.request.FilmeRequest;
import br.com.cwi.reset.isaquexavierdossantos.service.EstudioService;
import br.com.cwi.reset.isaquexavierdossantos.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
    @Autowired
    private FilmeService service;

    /*private FilmeService filmeService;
us
    public FilmeController() {

        this.filmeService = new FilmeService(FakeDatabase.getInstance());
    }
     */

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarFilme(@RequestBody FilmeRequest filmeRequest) throws Exception {
        service.criarFilme(filmeRequest);//esse
    }

    @GetMapping
    public List<Filme> consultarFilmes(
            @RequestParam String nomeFilme,
            @RequestParam String nomeDiretor,
            @RequestParam String nomePersonagem,
            @RequestParam String nomeAtor) throws Exception {
        return service.consultarFilmes(nomeFilme, nomeDiretor, nomePersonagem, nomeAtor);//esse
    }
}