package br.com.cwi.reset.josealencar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import br.com.cwi.reset.josealencar.FakeDatabase;
import br.com.cwi.reset.josealencar.model.Diretor;
import br.com.cwi.reset.josealencar.request.DiretorRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class DiretorServiceTest {

    private DiretorService diretorService;

    @BeforeEach
    public void setUp() {
        diretorService = new DiretorService(FakeDatabase.getInstance());
    }

    @Test
    public void deveRetornarErroQuandoNomeNulo() {
        String nome = null;
        LocalDate dataNascimento = LocalDate.of(1956, Month.JANUARY, 3);
        Integer anoInicioAtividade = 1976;
        DiretorRequest diretorRequest = new DiretorRequest(nome, dataNascimento, anoInicioAtividade);

        Exception e = assertThrows(
                Exception.class,
                () -> diretorService.cadastrarDiretor(diretorRequest),
                "Esperado exceção de campo obrigatório [nome]."
        );
        String expected = "Campo obrigatório não informado. Favor informar o campo nome.";
        assertEquals(expected, e.getMessage());
    }

    @Test
    public void deveRetornarErroQuandoDataNascimentoNulo() {
        String nome = "Mel Gibson";
        LocalDate dataNascimento = null;
        Integer anoInicioAtividade = 1976;
        DiretorRequest diretorRequest = new DiretorRequest(nome, dataNascimento, anoInicioAtividade);

        Exception e = assertThrows(
                Exception.class,
                () -> diretorService.cadastrarDiretor(diretorRequest),
                "Esperado exceção de campo obrigatório [dataNascimento]."
        );
        String expected = "Campo obrigatório não informado. Favor informar o campo dataNascimento.";
        assertEquals(expected, e.getMessage());
    }

    @Test
    public void deveRetornarErroQuandoAnoInicioAtividadeNulo() {
        String nome = "Mel Gibson";
        LocalDate dataNascimento = LocalDate.of(1956, Month.JANUARY, 3);
        Integer anoInicioAtividade = null;
        DiretorRequest diretorRequest = new DiretorRequest(nome, dataNascimento, anoInicioAtividade);

        Exception e = assertThrows(
                Exception.class,
                () -> diretorService.cadastrarDiretor(diretorRequest),
                "Esperado exceção de campo obrigatório [anoInicioAtividade]."
        );
        String expected = "Campo obrigatório não informado. Favor informar o campo anoInicioAtividade.";
        assertEquals(expected, e.getMessage());
    }

    @Test
    public void deveRetornarErroQuandoDiretorPossuirSomenteNome() {
        String nome = "Mel";
        LocalDate dataNascimento = LocalDate.of(1956, Month.JANUARY, 3);
        Integer anoInicioAtividade = 1976;
        DiretorRequest diretorRequest = new DiretorRequest(nome, dataNascimento, anoInicioAtividade);

        Exception e = assertThrows(
                Exception.class,
                () -> diretorService.cadastrarDiretor(diretorRequest),
                "Esperado exceção de nome e sobrenome obrigatórios."
        );
        String expected = "Deve ser informado no mínimo nome e sobrenome para o diretor.";
        assertEquals(expected, e.getMessage());
    }

    @Test
    public void deveRetornarErroQuandoDiretorNaoNascido() {
        String nome = "Mel Gibson";
        LocalDate dataNascimento = LocalDate.of(LocalDate.now().getYear() + 10, Month.JANUARY, 3);
        Integer anoInicioAtividade = 1976;
        DiretorRequest diretorRequest = new DiretorRequest(nome, dataNascimento, anoInicioAtividade);

        Exception e = assertThrows(
                Exception.class,
                () -> diretorService.cadastrarDiretor(diretorRequest),
                "Esperado exceção de data nascimento posterior a atual."
        );
        String expected = "Não é possível cadastrar diretores não nascidos.";
        assertEquals(expected, e.getMessage());
    }

    @Test
    public void deveRetornarErroQuandoDiretorComInicioAtividadeAnteriorNascimento() {
        String nome = "Mel Gibson";
        LocalDate dataNascimento = LocalDate.of(1956, Month.JANUARY, 3);
        Integer anoInicioAtividade = 1926;
        DiretorRequest diretorRequest = new DiretorRequest(nome, dataNascimento, anoInicioAtividade);

        Exception e = assertThrows(
                Exception.class,
                () -> diretorService.cadastrarDiretor(diretorRequest),
                "Esperado exceção de ano inicio de atividade anterior ao nascimento."
        );
        String expected = "Ano de início de atividade inválido para o diretor cadastrado.";
        assertEquals(expected, e.getMessage());
    }

    @Test
    public void deveRetornarErroQuandoDiretorJaExistenteComMesmoNome() throws Exception {
        String nome = "Mel Gibson";
        String nome2 = "mel gibson";
        LocalDate dataNascimento = LocalDate.of(1956, Month.JANUARY, 3);
        Integer anoInicioAtividade = 1976;
        DiretorRequest diretorRequest = new DiretorRequest(nome, dataNascimento, anoInicioAtividade);
        DiretorRequest diretorRequest2 = new DiretorRequest(nome2, dataNascimento, anoInicioAtividade);

        diretorService.cadastrarDiretor(diretorRequest);
        Exception e = assertThrows(
                Exception.class,
                () -> diretorService.cadastrarDiretor(diretorRequest2),
                "Esperado exceção de diretor já existente."
        );
        String expected = "Já existe um diretor cadastrado para o nome mel gibson.";
        assertEquals(expected, e.getMessage());
    }

    @Test
    public void deveSalvarDiretorEConsultarListaComUmNovoDiretor() throws Exception {
        String nome = "Mel Gibson";
        LocalDate dataNascimento = LocalDate.of(1956, Month.JANUARY, 3);
        Integer anoInicioAtividade = 1976;
        DiretorRequest diretorRequest = new DiretorRequest(nome, dataNascimento, anoInicioAtividade);

        diretorService.cadastrarDiretor(diretorRequest);

        assertEquals(1, diretorService.listarDiretores(null).size());
    }

    @Test
    public void deveRetornarErroQuandoNenhumDiretorCadastradoNaConsulta() {
        Exception e = assertThrows(
                Exception.class,
                () -> diretorService.listarDiretores(null),
                "Esperado exceção de diretores não cadastrados."
        );
        String expected = "Nenhum diretor cadastrado, favor cadastar diretores.";
        assertEquals(expected, e.getMessage());
    }

    @Test
    public void deveRetornarErroQuandoNenhumDiretorCadastradoComFiltroInformado() throws Exception {
        String nome = "Mel Gibson";
        LocalDate dataNascimento = LocalDate.of(1956, Month.JANUARY, 3);
        Integer anoInicioAtividade = 1976;
        DiretorRequest diretorRequest = new DiretorRequest(nome, dataNascimento, anoInicioAtividade);

        diretorService.cadastrarDiretor(diretorRequest);
        Exception e = assertThrows(
                Exception.class,
                () -> diretorService.listarDiretores("teste"),
                "Esperado exceção de diretores não cadastrados para o filtro."
        );
        String expected = "Diretor não encontrato com o filtro teste, favor informar outro filtro.";
        assertEquals(expected, e.getMessage());
    }

    @Test
    public void deveRetornarApenasFiltradosPorNome() throws Exception {
        String nome = "Mel Gibson";
        LocalDate dataNascimento = LocalDate.of(1956, Month.JANUARY, 3);
        Integer anoInicioAtividade = 1976;
        DiretorRequest diretorRequest = new DiretorRequest(nome, dataNascimento, anoInicioAtividade);

        String nome2 = "Michael Hoffman";
        LocalDate dataNascimento2 = LocalDate.of(1956, Month.NOVEMBER, 30);
        Integer anoInicioAtividade2 = 1982;
        DiretorRequest diretorRequest2 = new DiretorRequest(nome2, dataNascimento2, anoInicioAtividade2);

        diretorService.cadastrarDiretor(diretorRequest);
        diretorService.cadastrarDiretor(diretorRequest2);

        List<Diretor> diretores = diretorService.listarDiretores("gib");

        assertEquals(1, diretores.size());
    }

    @Test
    public void deveRetornarTodosOsDiretores() throws Exception {
        String nome = "Mel Gibson";
        LocalDate dataNascimento = LocalDate.of(1956, Month.JANUARY, 3);
        Integer anoInicioAtividade = 1976;
        DiretorRequest diretorRequest = new DiretorRequest(nome, dataNascimento, anoInicioAtividade);

        String nome2 = "Michael Hoffman";
        LocalDate dataNascimento2 = LocalDate.of(1956, Month.NOVEMBER, 30);
        Integer anoInicioAtividade2 = 1982;
        DiretorRequest diretorRequest2 = new DiretorRequest(nome2, dataNascimento2, anoInicioAtividade2);

        diretorService.cadastrarDiretor(diretorRequest);
        diretorService.cadastrarDiretor(diretorRequest2);

        List<Diretor> diretores = diretorService.listarDiretores(null);

        assertEquals(2, diretores.size());
    }

    @Test
    public void deveRetornarErroQuandoConsultaDiretorNaoInformarId() {
        Exception e = assertThrows(
                Exception.class,
                () -> diretorService.consultarDiretor(null),
                "Esperado exceção de campo obrigatório [id]."
        );
        String expected = "Campo obrigatório não informado. Favor informar o campo id.";
        assertEquals(expected, e.getMessage());
    }

    @Test
    public void deveRetornarErroQuandoConsultaDiretorNaoEncontrarDiretorPorId() throws Exception {
        String nome = "Mel Gibson";
        LocalDate dataNascimento = LocalDate.of(1956, Month.JANUARY, 3);
        Integer anoInicioAtividade = 1976;
        DiretorRequest diretorRequest = new DiretorRequest(nome, dataNascimento, anoInicioAtividade);

        diretorService.cadastrarDiretor(diretorRequest);
        Exception e = assertThrows(
                Exception.class,
                () -> diretorService.consultarDiretor(1000),
                "Esperado exceção de ator não encontrado com id informado."
        );
        String expected = "Nenhum diretor encontrado com o parâmetro id=1000, favor verifique os parâmetros informados.";
        assertEquals(expected, e.getMessage());
    }

    @Test
    public void deveRetornarDiretorPorId() throws Exception {
        String nome = "Mel Gibson";
        LocalDate dataNascimento = LocalDate.of(1956, Month.JANUARY, 3);
        Integer anoInicioAtividade = 1976;
        DiretorRequest diretorRequest = new DiretorRequest(nome, dataNascimento, anoInicioAtividade);

        diretorService.cadastrarDiretor(diretorRequest);

        Diretor diretor = diretorService.consultarDiretor(1);

        assertEquals(nome, diretor.getNome());
    }
}