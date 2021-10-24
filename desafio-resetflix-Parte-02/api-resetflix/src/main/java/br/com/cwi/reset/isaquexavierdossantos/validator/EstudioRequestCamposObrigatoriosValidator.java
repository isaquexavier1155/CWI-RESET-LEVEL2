package br.com.cwi.reset.isaquexavierdossantos.validator;

import br.com.cwi.reset.isaquexavierdossantos.exception.DataCriacaoNaoInformadaException;
import br.com.cwi.reset.isaquexavierdossantos.exception.DescricaoNaoInformadaException;
import br.com.cwi.reset.isaquexavierdossantos.exception.NomeNaoInformadoException;
import br.com.cwi.reset.isaquexavierdossantos.exception.StatusAtividadeNaoInformadoException;
import br.com.cwi.reset.isaquexavierdossantos.request.EstudioRequest;

import static java.util.Objects.isNull;

public class EstudioRequestCamposObrigatoriosValidator {

    public void accept(EstudioRequest estudioRequest) throws Exception {
        if (isNull(estudioRequest.getNome())) {
            throw new NomeNaoInformadoException();
        }

        if (isNull(estudioRequest.getDataCriacao())) {
            throw new DataCriacaoNaoInformadaException();
        }

        if (isNull(estudioRequest.getDescricao())) {
            throw new DescricaoNaoInformadaException();
        }

        if (isNull(estudioRequest.getStatusAtividade())) {
            throw new StatusAtividadeNaoInformadoException();
        }
    }
}