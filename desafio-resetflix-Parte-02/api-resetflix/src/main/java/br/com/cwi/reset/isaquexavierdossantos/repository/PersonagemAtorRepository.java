package br.com.cwi.reset.isaquexavierdossantos.repository;

import br.com.cwi.reset.isaquexavierdossantos.model.PersonagemAtor;
import org.springframework.data.repository.CrudRepository;

public interface PersonagemAtorRepository extends CrudRepository<PersonagemAtor, Integer> {
    // Ator findByNome(String name);
}
