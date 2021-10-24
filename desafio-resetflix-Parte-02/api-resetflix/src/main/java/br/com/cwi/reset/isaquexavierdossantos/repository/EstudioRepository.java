package br.com.cwi.reset.isaquexavierdossantos.repository;

import br.com.cwi.reset.isaquexavierdossantos.model.Estudio;
import org.springframework.data.repository.CrudRepository;

public interface EstudioRepository extends CrudRepository<Estudio, Integer>  {
    // Ator findByNome(String name);
}
