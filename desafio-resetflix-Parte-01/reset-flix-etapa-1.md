# Desafio resetflix - Parte 1

Fala Reseters, como estamos?

Galera, nesta nossa nova etapa de desafios, vamos construir uma aplicação/API completa do zero... Mas vamos fazer isto por etapas, serão 3 etapas ao total, que teremos desde o start inicial do projeto, até termos uma aplicação completa com banco de dados e serviços REST (se você ainda não sabe o que é isso, não se assute, vamos te explicar :smile:)

Nós vamos começar modelando nossa aplicação e adicionando algumas funcionalidades relacionadas aos filmes, vamos a elas!

## Setup do projeto

Para iniciarmos o projeto vamos seguir a seguinte estrutura:

- Acessar o repositório de cada um, e na raíz do projeto criar uma pasta chamada `desafio-resetflix`
- Abrir a IDE e criar um novo projeto com o nome `api-resetflix` na seguinte estrutura:
  - Projeto Maven
  - Projeto SDK -> Java 8 ou superior
  - Clicar em "Criar Projeto"
- No arquivo `pom.xml` vamos alterar a propriedade `<groupId>` para `br.com.cwi.reset.seunomeaqui` (importante, o seu nome deve estar todo em minúsculo e sem espaços, caso contrário o projeto não conseguirá ser executado)
- Navegando pela IDE vamos achar o diretório `api-resetflix > src > main > java` e vamos criar um novo pacote java no seguinte padrão:
  - `br.com.cwi.reset.seunomeaqui` (importante, o seu nome deve estar todo em minúsculo e sem espaços, caso contrário o projeto não conseguirá ser executado)

## Estrutura de Classes de Domínio

### Ator

- id
- nome
- dataNascimento
- StatusCarreira statusCarreira
  - EM_ATIVIDADE
  - APOSENTADO
- anoInicioAtividade

### Diretor

- id
- nome
- dataNascimento
- anoInicioAtividade

### Estudio

- id
- nome
- descricao
- dataCriacao
- StatusAtividade statusAtividade
  - EM_ATIVIDADE
  - ENCERRADO

### Filme

- id
- nome
- anoLancamento
- capaFilme
- List:Genero generos
  - ACAO
  - AVENTURA
  - COMEDIA
  - DOCUMENTARIO
  - DRAMA
  - ESPIONAGEM
  - FICCAO_CIENTIFICA
  - GUERRA
  - MISTERIO
  - MUSICAL
  - POLICIAL
  - ROMANCE
  - TERROR
- Diretor diretor
- List:PersonagemAtor personagens
- resumo

### PersonagemAtor

- id
- Ator ator
- nomePersonagem
- descricaoPersonagem
- TipoAtuacao tipoAtuacao
  - PRINCIPAL
  - COADJUVANTE

## Funcionalidades

### 0. Mensagens de erro

- **IMPORTANTE**: Todas as mensagens de erro devem estender Exception

### 1. Elenco

#### 1.1. Cadastrar ator

- Assinatura: Classe: AtorService | Retorno: void | Método: criarAtor(AtorRequest atorRequest)

  AtorRequest

  - nome*
  - dataNascimento*
  - StatusCarreira statusCarreira*
    - EM_ATIVIDADE
    - APOSENTADO
  - anoInicioAtividade*
- Característica: Incluir um novo ator a lista de atores
- Regras
  - Campos com * são campos obrigatórios
    - Mensagem de erro: "Campo obrigatório não informado. Favor informar o campo {campo}."
  - O id (numérico) do ator deve ser gerado automáticamente de forma sequencial
  - Deve obrigar pelo menos nome e sobrenome do ator
    - Mensagem de erro: "Deve ser informado no mínimo nome e sobrenome para o ator."
  - A data de nascimento não pode ser maior que a data atual
    - Mensagem de erro: "Não é possível cadastrar atores não nascidos."
  - O ano de início de atividade não pode ser anterior ao ano de nascimento do ator
    - Mensagem de erro: "Ano de início de atividade inválido para o ator cadastrado."
  - Não deve ser permitido cadastrar dois atores com o mesmo nome
    - Mensagem de erro: "Já existe um ator cadastrado para o nome {nome}."

#### 1.2. Listar atores

- Assinatura: Classe: AtorService | Retorno: List<AtorEmAtividade> | Método: listarAtoresEmAtividade(String filtroNome)

  AtorEmAtividade

  - id
  - nome
  - dataNascimento
- Característica: Retornar os dados de todos os atores em atividade
- Regras
  - O campo filtroNome é opcional, quando informado deve filtrar por qualquer match na sequência do nome, 
    Exemplo: filtroNome -> roll
             ator encontrado -> Willard Carroll Smith Jr
  - Deve retornar apenas os atores com o statusCarreira = EM_ATIVIDADE
  - Caso não exista atores cadastrados deve retornar a mensagem de erro: "Nenhum ator cadastrado, favor cadastar atores."
  - Caso não seja encontrado nenhum ator com o filtro deve retornar a mensagem de erro: "Ator não encontrato com o filtro {filtro}, favor informar outro filtro."

#### 1.3. Consultar ator

- Assinatura: Classe: AtorService | Retorno: Ator | Método: consultarAtor(Integer id)
- Característica: Retornar os dados do ator
- Regras
  - O filtro id é obrigatório
    - Mensagem de erro: "Campo obrigatório não informado. Favor informar o campo {campo}."
  - Deve retornar o ator filtrado pelo id
  - Caso não encontrado o Ator, deve retornar a mensagem de erro: "Nenhum ator encontrado com o parâmetro id={campo}, favor verifique os parâmetros informados."

#### 1.4. Todos os atores

- Assinatura: Classe: AtorService | Retorno: List<Ator> | Método: consultarAtores()
- Característica: Retornar os dados de todos os atores
- Regras
  - Deve retornar todos os atores cadastrados
  - Caso não exista atores cadastrados deve retornar a mensagem de erro: "Nenhum ator cadastrado, favor cadastar atores."

### 1. Direção

#### 1.1. Cadastrar diretor

- Assinatura: Classe: DiretorService | Retorno: void | Método: cadastrarDiretor(DiretorRequest diretorRequest)

  DiretorRequest

  - nome*
  - dataNascimento*
  - anoInicioAtividade*
- Característica: Incluir um novo diretor a lista de diretores
- Regras
  - Campos com * são campos obrigatórios
    - Mensagem de erro: "Campo obrigatório não informado. Favor informar o campo {campo}."
  - O id (numérico) do diretor deve ser gerado automáticamente de forma sequencial
  - Deve obrigar pelo menos nome e sobrenome do diretor
    - Mensagem de erro: "Deve ser informado no mínimo nome e sobrenome para o diretor."
  - A data de nascimento não pode ser maior que a data atual
    - Mensagem de erro: "Não é possível cadastrar diretores não nascidos."
  - O ano de início de atividade não pode ser anterior ao ano de nascimento do diretor
    - Mensagem de erro: "Ano de início de atividade inválido para o diretor cadastrado."
  - Não deve ser permitido cadastrar dois diretores com o mesmo nome
    - Mensagem de erro: "Já existe um diretor cadastrado para o nome {nome}."

#### 1.2. Listar diretores

- Assinatura: Classe: DiretorService | Retorno: List<Diretor> | Método: listarDiretores(String filtroNome)
- Característica: Retornar os dados de todos os diretores
- Regras
  - O campo filtroNome é opcional, quando informado deve filtrar por qualquer match na sequência do nome, 
    Exemplo: filtroNome -> yle
             diretor encontrado -> Ryan Kyle Coogler
  - Caso não exista diretores cadastrados deve retornar a mensagem de erro: "Nenhum diretor cadastrado, favor cadastar diretores."
  - Caso não seja encontrado nenhum diretor com o filtro deve retornar a mensagem de erro: "Diretor não encontrato com o filtro {filtro}, favor informar outro filtro."

#### 1.3. Consultar diretor

- Assinatura: Classe: DiretorService | Retorno: Diretor | Método: consultarDiretor(Integer id)
- Característica: Retornar os dados do diretor
- Regras
  - O filtro id é obrigatório
    - Mensagem de erro: "Campo obrigatório não informado. Favor informar o campo {campo}."
  - Deve retornar o diretor filtrado pelo id
  - Caso não encontrado o diretor, deve retornar a mensagem de erro: "Nenhum diretor encontrado com o parâmetro id={}, favor verifique os parâmetros informados."

## Observações complementares

Para executarmos este exercício, teremos uma base de dados falsa com dados em memória na execução do nosso programa, para isto, basta copiar a classe que temos abaixo para o seu projeto.

**IMPORTANTE**: Esta classe depende de outras classes que devem ser importadas para correto funcionamento.

```java
import java.util.ArrayList;
import java.util.List;

public class FakeDatabase {

    private List<Ator> atores = new ArrayList<>();
    private List<Diretor> diretores = new ArrayList<>();

    public void persisteAtor(Ator ator) {
        atores.add(ator);
    }

    public List<Ator> recuperaAtores() {
        return atores;
    }

    public void persisteDiretor(Diretor diretor) {
        diretores.add(diretor);
    }

    public List<Diretor> recuperaDiretores() {
        return diretores;
    }
}

```

------------------------------------

Nos arquivos `AtorService` e `DiretorService` deve ser incluído uma propriedade que se refere a classe `FakeDatabase`, e a mesma deve ser recebida pelo construtor, segue um exemplo de como deve ficar a classe `AtorService`.

**IMPORTANTE**: Esta classe depende de outras classes que devem ser importadas para correto funcionamento.

```java
public class AtorService {

    private FakeDatabase fakeDatabase;

    public AtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    // Demais métodos da classe
}
```

------------------------------------

Para execução do projeto, deve ser criado a classe `Aplicacao` contendo o método `main` que será utilizado para chamar os métodos criados e testar os cenários, segue um exemplo abaixo de como ficaria a classe para validar que um ator foi criado com sucesso.

**IMPORTANTE**: Esta classe depende de outras classes que devem ser importadas para correto funcionamento.

```java
public class Aplicacao {

    public static void main(String[] args) {
        FakeDatabase fakeDatabase = new FakeDatabase();

        AtorService atorService = new AtorService(fakeDatabase);

        String nome = "Will Smith";
        LocalDate dataNascimento = LocalDate.of(1968, Month.SEPTEMBER, 25);
        StatusCarreira statusCarreira = StatusCarreira.EM_ATIVIDADE;
        Integer anoInicioAtividade = 1986;
        AtorRequest atorRequest = new AtorRequest(nome, dataNascimento, statusCarreira, anoInicioAtividade);

        atorService.criarAtor(atorRequest);

        List<Ator> atores = fakeDatabase.recuperaAtores();

        System.out.println("Deve conter 1 ator, quantidade encontrada: " + atores.size());
        System.out.println("Primeiro ator deve ser 'Will Smith', valor encontrado: " + atores.get(0).getNome());
    }
}
```

------------------------------------

**Os contratos especificados no exercício devem ser respeitados, caso alguma nomenclatura especificada seja alterada, os instrutores e monitores podem solicitar o ajuste. Caso o ajuste não seja realizado, não será garantido uma avaliação do exercício proposto.**
