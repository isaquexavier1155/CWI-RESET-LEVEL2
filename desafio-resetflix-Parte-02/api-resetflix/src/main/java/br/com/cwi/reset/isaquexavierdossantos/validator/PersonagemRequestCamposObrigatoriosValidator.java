package br.com.cwi.reset.isaquexavierdossantos.validator;

import br.com.cwi.reset.isaquexavierdossantos.exception.DescricaoPersonagemNaoInformadaException;
import br.com.cwi.reset.isaquexavierdossantos.exception.IdAtorNaoInformadoException;
import br.com.cwi.reset.isaquexavierdossantos.exception.NomeNaoInformadoException;
import br.com.cwi.reset.isaquexavierdossantos.exception.TipoAtuacaoNaoInformadoException;
import br.com.cwi.reset.isaquexavierdossantos.request.PersonagemRequest;

import static java.util.Objects.isNull;

public class PersonagemRequestCamposObrigatoriosValidator {

    public void accept(final PersonagemRequest personagemRequest) throws Exception {
        if (isNull(personagemRequest.getNomePersonagem())) {
            throw new NomeNaoInformadoException();
        }

        if (isNull(personagemRequest.getDescricaoPersonagem())) {
            throw new DescricaoPersonagemNaoInformadaException();
        }

        if (isNull(personagemRequest.getIdAtor())) {
            throw new IdAtorNaoInformadoException();
        }

        if (isNull(personagemRequest.getTipoAtuacao())) {
            throw new TipoAtuacaoNaoInformadoException();
        }
    }
}