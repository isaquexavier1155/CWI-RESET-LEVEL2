package br.com.cwi.reset.isaquexavierdossantos;

import br.com.cwi.reset.isaquexavierdossantos.exception.NomeNaoInformadoException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {
    
    @PostMapping
    public String helloWorld() throws Exception {
  throw new NomeNaoInformadoException();//força umas das Exceptions
       // return "Minha API resetflix está UPppppp!!!";
    }
}