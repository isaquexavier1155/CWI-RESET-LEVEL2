package br.com.cwi.reset.isaquexavierdossantos.repository;

import br.com.cwi.reset.isaquexavierdossantos.model.Filme;
import org.springframework.data.repository.CrudRepository;

public interface FilmeRepository extends CrudRepository<Filme, Integer>  {
    // Ator findByNome(String name);
}
