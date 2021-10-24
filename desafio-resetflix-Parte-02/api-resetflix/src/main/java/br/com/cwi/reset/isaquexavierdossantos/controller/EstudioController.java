package br.com.cwi.reset.isaquexavierdossantos.controller;

import br.com.cwi.reset.isaquexavierdossantos.FakeDatabase;
import br.com.cwi.reset.isaquexavierdossantos.model.Estudio;
import br.com.cwi.reset.isaquexavierdossantos.request.EstudioRequest;
import br.com.cwi.reset.isaquexavierdossantos.service.DiretorService;
import br.com.cwi.reset.isaquexavierdossantos.service.EstudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudios")
public class EstudioController {
    @Autowired
    private EstudioService service;

   /* private EstudioService estudioService;

    public EstudioController() {
        this.estudioService = new EstudioService(FakeDatabase.getInstance());
    }
    */


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarEstudio(@RequestBody EstudioRequest estudioRequest) throws Exception {
        estudioService.criarEstudio(estudioRequest);
    }

    @GetMapping
    public List<Estudio> consultarEstudios(@RequestParam String filtroNome) throws Exception {
        return estudioService.consultarEstudios(filtroNome);
    }

    @GetMapping(path = "/{id}")
    public Estudio consultarEstudio(@PathVariable Integer id) throws Exception {
        return estudioService.consultarEstudio(id);
    }
}