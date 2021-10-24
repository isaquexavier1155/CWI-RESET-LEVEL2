package br.com.cwi.reset.isaquexavierdossantos.repository;

import br.com.cwi.reset.isaquexavierdossantos.model.Diretor;
import org.springframework.data.repository.CrudRepository;

public interface DiretorRepository extends CrudRepository<Diretor, Integer> {
    // Ator findByNome(String name);
}
