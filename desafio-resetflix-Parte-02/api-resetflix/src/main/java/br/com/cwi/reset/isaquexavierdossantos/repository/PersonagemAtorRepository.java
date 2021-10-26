package br.com.cwi.reset.isaquexavierdossantos.repository;

import br.com.cwi.reset.isaquexavierdossantos.model.Ator;
import br.com.cwi.reset.isaquexavierdossantos.model.PersonagemAtor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonagemAtorRepository extends CrudRepository<PersonagemAtor, Integer> {
    // Ator findByNome(String name);
    List<PersonagemAtor> findAll();
}
