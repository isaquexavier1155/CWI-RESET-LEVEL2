package br.com.cwi.reset.josealencar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import br.com.cwi.reset.josealencar.FakeDatabase;
import br.com.cwi.reset.josealencar.model.Ator;
import br.com.cwi.reset.josealencar.model.StatusCarreira;
import br.com.cwi.reset.josealencar.request.AtorRequest;
import br.com.cwi.reset.josealencar.response.AtorEmAtividade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class AtorServiceTest {

    private AtorService atorService;

    @BeforeEach
    public void setUp() {
        atorService = new AtorService(FakeDatabase.getInstance());
    }

    @Test
    public void deveRetornarErroQuandoNomeNulo() {
        String nome = null;
        LocalDate dataNascimento = LocalDate.of(1968, Month.SEPTEMBER, 25);
        StatusCarreira statusCarreira = StatusCarreira.EM_ATIVIDADE;
        Integer anoInicioAtividade = 1986;
        AtorRequest atorRequest = new AtorRequest(nome, dataNascimento, statusCarreira, anoInicioAtividade);

        Exception e = assertThrows(
                Exception.class,
                () -> atorService.criarAtor(atorRequest),
                "Esperado exceção de campo obrigatório [nome]."
        );
        String expected = "Campo obrigatório não informado. Favor informar o campo nome.";
        assertEquals(expected, e.getMessage());
    }

    @Test
    public void deveRetornarErroQuandoDataNascimentoNulo() {
        String nome = "Will Smith";
        LocalDate dataNascimento = null;
        StatusCarreira statusCarreira = StatusCarreira.EM_ATIVIDADE;
        Integer anoInicioAtividade = 1986;
        AtorRequest atorRequest = new AtorRequest(nome, dataNascimento, statusCarreira, anoInicioAtividade);

        Exception e = assertThrows(
                Exception.class,
                () -> atorService.criarAtor(atorRequest),
                "Esperado exceção de campo obrigatório [dataNascimento]."
        );
        String expected = "Campo obrigatório não informado. Favor informar o campo dataNascimento.";
        assertEquals(expected, e.getMessage());
    }

    @Test
    public void deveRetornarErroQuandoStatusCarreiraNulo() {
        String nome = "Will Smith";
        LocalDate dataNascimento = LocalDate.of(1968, Month.SEPTEMBER, 25);
        StatusCarreira statusCarreira = null;
        Integer anoInicioAtividade = 1986;
        AtorRequest atorRequest = new AtorRequest(nome, dataNascimento, statusCarreira, anoInicioAtividade);

        Exception e = assertThrows(
                Exception.class,
                () -> atorService.criarAtor(atorRequest),
                "Esperado exceção de campo obrigatório [statusCarreira]."
        );
        String expected = "Campo obrigatório não informado. Favor informar o campo statusCarreira.";
        assertEquals(expected, e.getMessage());
    }

    @Test
    public void deveRetornarErroQuandoAnoInicioAtividadeNulo() {
        String nome = "Will Smith";
        LocalDate dataNascimento = LocalDate.of(1968, Month.SEPTEMBER, 25);
        StatusCarreira statusCarreira = StatusCarreira.EM_ATIVIDADE;
        Integer anoInicioAtividade = null;
        AtorRequest atorRequest = new AtorRequest(nome, dataNascimento, statusCarreira, anoInicioAtividade);

        Exception e = assertThrows(
                Exception.class,
                () -> atorService.criarAtor(atorRequest),
                "Esperado exceção de campo obrigatório [anoInicioAtividade]."
        );
        String expected = "Campo obrigatório não informado. Favor informar o campo anoInicioAtividade.";
        assertEquals(expected, e.getMessage());
    }

    @Test
    public void deveRetornarErroQuandoAtorPossuirSomenteNome() {
        String nome = "Will";
        LocalDate dataNascimento = LocalDate.of(1968, Month.SEPTEMBER, 25);
        StatusCarreira statusCarreira = StatusCarreira.EM_ATIVIDADE;
        Integer anoInicioAtividade = 1986;
        AtorRequest atorRequest = new AtorRequest(nome, dataNascimento, statusCarreira, anoInicioAtividade);

        Exception e = assertThrows(
                Exception.class,
                () -> atorService.criarAtor(atorRequest),
                "Esperado exceção de mínimo dois nomes."
        );
        String expected = "Deve ser informado no mínimo nome e sobrenome para o ator.";
        assertEquals(expected, e.getMessage());
    }

    @Test
    public void deveRetornarErroQuandoAtorNaoNascido() {
        String nome = "Will Smith";
        LocalDate dataNascimento = LocalDate.of(LocalDate.now().getYear() + 10, Month.SEPTEMBER, 25);
        StatusCarreira statusCarreira = StatusCarreira.EM_ATIVIDADE;
        Integer anoInicioAtividade = 1986;
        AtorRequest atorRequest = new AtorRequest(nome, dataNascimento, statusCarreira, anoInicioAtividade);

        Exception e = assertThrows(
                Exception.class,
                () -> atorService.criarAtor(atorRequest),
                "Esperado exceção de ano nascimento posterior ao ano atual."
        );
        String expected = "Não é possível cadastrar atores não nascidos.";
        assertEquals(expected, e.getMessage());
    }

    @Test
    public void deveRetornarErroQuandoAtorComInicioAtividadeAnteriorNascimento() {
        String nome = "Will Smith";
        LocalDate dataNascimento = LocalDate.of(1968, Month.SEPTEMBER, 25);
        StatusCarreira statusCarreira = StatusCarreira.EM_ATIVIDADE;
        Integer anoInicioAtividade = 1956;
        AtorRequest atorRequest = new AtorRequest(nome, dataNascimento, statusCarreira, anoInicioAtividade);

        Exception e = assertThrows(
                Exception.class,
                () -> atorService.criarAtor(atorRequest),
                "Esperado exceção de ano inicio de atividade anterior ao nascimento."
        );
        String expected = "Ano de início de atividade inválido para o ator cadastrado.";
        assertEquals(expected, e.getMessage());
    }

    @Test
    public void deveRetornarErroQuandoAtorJaExistenteComMesmoNome() throws Exception {
        String nome = "Will Smith";
        String nome2 = "will smith";
        LocalDate dataNascimento = LocalDate.of(1968, Month.SEPTEMBER, 25);
        StatusCarreira statusCarreira = StatusCarreira.EM_ATIVIDADE;
        Integer anoInicioAtividade = 1986;
        AtorRequest atorRequest = new AtorRequest(nome, dataNascimento, statusCarreira, anoInicioAtividade);
        AtorRequest atorRequest2 = new AtorRequest(nome2, dataNascimento, statusCarreira, anoInicioAtividade);

        atorService.criarAtor(atorRequest);

        Exception e = assertThrows(
                Exception.class,
                () -> atorService.criarAtor(atorRequest2),
                "Esperado exceção de ator já cadastrado."
        );
        String expected = "Já existe um ator cadastrado para o nome will smith.";
        assertEquals(expected, e.getMessage());

        assertEquals(1, atorService.consultarAtores().size());
    }

    @Test
    public void deveSalvarAtorEConsultarListaComUmNovoAtor() throws Exception {
        String nome = "Will Smith";
        LocalDate dataNascimento = LocalDate.of(1968, Month.SEPTEMBER, 25);
        StatusCarreira statusCarreira = StatusCarreira.EM_ATIVIDADE;
        Integer anoInicioAtividade = 1986;
        AtorRequest atorRequest = new AtorRequest(nome, dataNascimento, statusCarreira, anoInicioAtividade);

        atorService.criarAtor(atorRequest);

        assertEquals(1, atorService.consultarAtores().size());
    }

    @Test
    public void deveRetornarErroQuandoNenhumAtorCadastradoNaConsulta() throws Exception {
        Exception e = assertThrows(
                Exception.class,
                () -> atorService.listarAtoresEmAtividade(null),
                "Esperado exceção de nenhum ator cadastrado."
        );
        String expected = "Nenhum ator cadastrado, favor cadastar atores.";
        assertEquals(expected, e.getMessage());
    }

    @Test
    public void deveRetornarErroQuandoNenhumAtorCadastradoComFiltroInformado() throws Exception {
        String nome = "Will Smith";
        LocalDate dataNascimento = LocalDate.of(1968, Month.SEPTEMBER, 25);
        StatusCarreira statusCarreira = StatusCarreira.EM_ATIVIDADE;
        Integer anoInicioAtividade = 1986;
        AtorRequest atorRequest = new AtorRequest(nome, dataNascimento, statusCarreira, anoInicioAtividade);

        atorService.criarAtor(atorRequest);
        Exception e = assertThrows(
                Exception.class,
                () -> atorService.listarAtoresEmAtividade("teste"),
                "Esperado exceção de nenhum ator cadastrado para filtro informado."
        );
        String expected = "Ator não encontrato com o filtro teste, favor informar outro filtro.";
        assertEquals(expected, e.getMessage());
    }

    @Test
    public void deveRetornarApenasAtoresEmAtividade() throws Exception {
        String nome = "Will Smith";
        LocalDate dataNascimento = LocalDate.of(1968, Month.SEPTEMBER, 25);
        StatusCarreira statusCarreira = StatusCarreira.EM_ATIVIDADE;
        Integer anoInicioAtividade = 1986;
        AtorRequest atorRequest = new AtorRequest(nome, dataNascimento, statusCarreira, anoInicioAtividade);

        String nomeAtriz = "Cameron Diaz";
        LocalDate dataNascimentoAtriz = LocalDate.of(1972, Month.AUGUST, 30);
        StatusCarreira statusCarreiraAtriz = StatusCarreira.APOSENTADO;
        Integer anoInicioAtividadeAtriz = 1990;
        AtorRequest atrizRequest = new AtorRequest(nomeAtriz, dataNascimentoAtriz, statusCarreiraAtriz, anoInicioAtividadeAtriz);

        atorService.criarAtor(atorRequest);
        atorService.criarAtor(atrizRequest);

        List<AtorEmAtividade> atorEmAtividades = atorService.listarAtoresEmAtividade(null);

        assertEquals(1, atorEmAtividades.size());
    }

    @Test
    public void deveRetornarApenasFiltradosPorNome() throws Exception {
        String nome = "Will Smith";
        LocalDate dataNascimento = LocalDate.of(1968, Month.SEPTEMBER, 25);
        StatusCarreira statusCarreira = StatusCarreira.EM_ATIVIDADE;
        Integer anoInicioAtividade = 1986;
        AtorRequest atorRequest = new AtorRequest(nome, dataNascimento, statusCarreira, anoInicioAtividade);

        String nome2 = "Mel Gibson";
        LocalDate dataNascimento2 = LocalDate.of(1956, Month.JANUARY, 3);
        StatusCarreira statusCarreira2 = StatusCarreira.EM_ATIVIDADE;
        Integer anoInicioAtividade2 = 1976;
        AtorRequest atorRequest2 = new AtorRequest(nome2, dataNascimento2, statusCarreira2, anoInicioAtividade2);

        atorService.criarAtor(atorRequest);
        atorService.criarAtor(atorRequest2);

        List<AtorEmAtividade> atorEmAtividades = atorService.listarAtoresEmAtividade("mit");

        assertEquals(1, atorEmAtividades.size());
    }

    @Test
    public void deveRetornarAtoresEmAtividadeQuandoNaoInformadoFiltro() throws Exception {
        String nome = "Will Smith";
        LocalDate dataNascimento = LocalDate.of(1968, Month.SEPTEMBER, 25);
        StatusCarreira statusCarreira = StatusCarreira.EM_ATIVIDADE;
        Integer anoInicioAtividade = 1986;
        AtorRequest atorRequest = new AtorRequest(nome, dataNascimento, statusCarreira, anoInicioAtividade);

        String nome2 = "Mel Gibson";
        LocalDate dataNascimento2 = LocalDate.of(1956, Month.JANUARY, 3);
        StatusCarreira statusCarreira2 = StatusCarreira.EM_ATIVIDADE;
        Integer anoInicioAtividade2 = 1976;
        AtorRequest atorRequest2 = new AtorRequest(nome2, dataNascimento2, statusCarreira2, anoInicioAtividade2);

        String nomeAtriz = "Cameron Diaz";
        LocalDate dataNascimentoAtriz = LocalDate.of(1972, Month.AUGUST, 30);
        StatusCarreira statusCarreiraAtriz = StatusCarreira.APOSENTADO;
        Integer anoInicioAtividadeAtriz = 1990;
        AtorRequest atrizRequest = new AtorRequest(nomeAtriz, dataNascimentoAtriz, statusCarreiraAtriz, anoInicioAtividadeAtriz);

        atorService.criarAtor(atorRequest);
        atorService.criarAtor(atorRequest2);
        atorService.criarAtor(atrizRequest);

        List<AtorEmAtividade> atorEmAtividades = atorService.listarAtoresEmAtividade(null);

        assertEquals(2, atorEmAtividades.size());
    }

    @Test
    public void deveRetornarErroQuandoNenhumAtorCadastradoNaConsultaDeTodosAtores() throws Exception {
        Exception e = assertThrows(
                Exception.class,
                () -> atorService.consultarAtores(),
                "Esperado exceção de nenhum ator cadastrado."
        );
        String expected = "Nenhum ator cadastrado, favor cadastar atores.";
        assertEquals(expected, e.getMessage());
    }

    @Test
    public void deveRetornarTodosOsAtores() throws Exception {
        String nome = "Will Smith";
        LocalDate dataNascimento = LocalDate.of(1968, Month.SEPTEMBER, 25);
        StatusCarreira statusCarreira = StatusCarreira.EM_ATIVIDADE;
        Integer anoInicioAtividade = 1986;
        AtorRequest atorRequest = new AtorRequest(nome, dataNascimento, statusCarreira, anoInicioAtividade);

        String nome2 = "Mel Gibson";
        LocalDate dataNascimento2 = LocalDate.of(1956, Month.JANUARY, 3);
        StatusCarreira statusCarreira2 = StatusCarreira.EM_ATIVIDADE;
        Integer anoInicioAtividade2 = 1976;
        AtorRequest atorRequest2 = new AtorRequest(nome2, dataNascimento2, statusCarreira2, anoInicioAtividade2);

        String nomeAtriz = "Cameron Diaz";
        LocalDate dataNascimentoAtriz = LocalDate.of(1972, Month.AUGUST, 30);
        StatusCarreira statusCarreiraAtriz = StatusCarreira.APOSENTADO;
        Integer anoInicioAtividadeAtriz = 1990;
        AtorRequest atrizRequest = new AtorRequest(nomeAtriz, dataNascimentoAtriz, statusCarreiraAtriz, anoInicioAtividadeAtriz);

        atorService.criarAtor(atorRequest);
        atorService.criarAtor(atorRequest2);
        atorService.criarAtor(atrizRequest);

        List<Ator> atores = atorService.consultarAtores();

        assertEquals(3, atores.size());
    }

    @Test
    public void deveRetornarErroQuandoConsultaAtorNaoInformarId() throws Exception {
        Exception e = assertThrows(
                Exception.class,
                () -> atorService.consultarAtor(null),
                "Esperado exceção de campo obrigatório [id]."
        );
        String expected = "Campo obrigatório não informado. Favor informar o campo id.";
        assertEquals(expected, e.getMessage());
    }

    @Test
    public void deveRetornarErroQuandoConsultaAtorNaoEncontrarAtorPorId() throws Exception {
        String nome = "Will Smith";
        LocalDate dataNascimento = LocalDate.of(1968, Month.SEPTEMBER, 25);
        StatusCarreira statusCarreira = StatusCarreira.EM_ATIVIDADE;
        Integer anoInicioAtividade = 1986;
        AtorRequest atorRequest = new AtorRequest(nome, dataNascimento, statusCarreira, anoInicioAtividade);

        atorService.criarAtor(atorRequest);
        Exception e = assertThrows(
                Exception.class,
                () -> atorService.consultarAtor(1000),
                "Esperado exceção de ator não encontrado por id."
        );
        String expected = "Nenhum ator encontrado com o parâmetro id=1000, favor verifique os parâmetros informados.";
        assertEquals(expected, e.getMessage());
    }

    @Test
    public void deveRetornarAtorPorId() throws Exception {
        String nome = "Will Smith";
        LocalDate dataNascimento = LocalDate.of(1968, Month.SEPTEMBER, 25);
        StatusCarreira statusCarreira = StatusCarreira.EM_ATIVIDADE;
        Integer anoInicioAtividade = 1986;
        AtorRequest atorRequest = new AtorRequest(nome, dataNascimento, statusCarreira, anoInicioAtividade);

        atorService.criarAtor(atorRequest);

        Ator ator = atorService.consultarAtor(1);

        assertEquals(nome, ator.getNome());
    }
}