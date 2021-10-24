package br.com.cwi.reset.isaquexavierdossantos.repository;

import br.com.cwi.reset.isaquexavierdossantos.model.Ator;
import org.springframework.data.repository.CrudRepository;

public interface AtorRepository extends CrudRepository<Ator, Integer> {
   // Ator findByNome(String name);
}
