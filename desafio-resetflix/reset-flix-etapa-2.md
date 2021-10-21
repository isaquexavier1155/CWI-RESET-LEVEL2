# Desafio resetflix - Parte 2

Prevejo pesadelos para a próxima semana :japanese_ogre: :see_no_evil:

## Transformando nossa aplicação em aplicação Web

Reseters, nesta semana vamos transformar nossa aplicação em uma aplicação em uma aplicação web, para que nossa aplicação se torne de fato uma API, vamos aos passos iniciais.

Para começarmos, vamos precisar ajustar nosso pom.xml para adicionarmos nossa dependência do framework do Spring Boot, para fazermos isso vamos acessar a URL so Spring Initializr (encontrada neste link: https://start.spring.io/) e vamos selecionar as seguintes opções (elas podem diferenciar em nome dependendo das configurações de linguagem do seu browser):

- Project -> Maven Project
- Language -> Java
- Spring Boot -> 2.5.5
- Project Metadata:
    - Group -> br.com.cwi.reset.{seunomeaqui}
    - Artifact -> api-resetflix
    - Name -> api-resetflix
    - Description -> {Não é necessário, pode colocar o que desejar}
    - Package name -> br.com.cwi.reset.{seunomeaqui}
- Packaging -> Jar
- Java -> 8

E nas dependências vamos selecionar a dependência do `Spring Web`

---

Após incluído todas as informações conforme acima vamos clicar no botão "Explore" que é apresentado no browser, e na tela que abrir, vamos procurar o arquivo pom.xml, e vamos substituir o arquivo existente do nosso projeto, com o arquivo gerado pelo site.

Segue um exemplo de como era nosso pom.xml:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>br.com.cwi.reset.josealencar</groupId>
    <artifactId>api-resetflix</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
    </properties>

</project>
```

E como deve ficar agora o nosso pom.xml:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.5.5</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>br.com.cwi.reset.josealencar</groupId>
	<artifactId>api-resetflix</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>api-resetflix</name>
	<properties>
		<java.version>1.8</java.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

</project>

```

---

Após esta etapa do nosso pom.xml, vamos ajustar a nossa a nossa classe `Aplicacao.java` para ser o nosso ponto de partida da nossa API Web. Para isto nós vamos basicamente modificar dois pontos, que são:

- Adicionar a anotação `@SpringBootApplication` acima da declaração de classe da `Aplicacao`
- Alterar o nosso método `main` para conter uma única linha de código, que será esta:

```java
SpringApplication.run(Aplicacao.class, args);
```

Exemplo da nossa classe `Aplicacao.java` antes da alteração:

```java
public class Aplicacao {

    public static void main(String[] args) {
        FakeDatabase fakeDatabase = new FakeDatabase();

        AtorService atorService = new AtorService(fakeDatabase);

        String nome = "Will Smith";
        LocalDate dataNascimento = LocalDate.of(1968, Month.SEPTEMBER, 25);
        StatusCarreira statusCarreira = StatusCarreira.EM_ATIVIDADE;
        Integer anoInicioAtividade = 1686;
        AtorRequest atorRequest = new AtorRequest(nome, dataNascimento, statusCarreira, anoInicioAtividade);

        atorService.criarAtor(atorRequest);

        List<Ator> atores = fakeDatabase.recuperaAtores();

        System.out.println("Deve conter 1 ator, quantidade encontrada: " + atores.size());
        System.out.println("Primeiro ator deve ser 'Will Smith', valor encontrado: " + atores.get(0).getNome());
    }
}
```

Exemplo da nossa classe `Aplicacao.java` após a alteração:

```java
@SpringBootApplication
public class Aplicacao {

    public static void main(String[] args) {
        SpringApplication.run(Aplicacao.class, args);
    }
}
```

Com estas etapas já temos a nossa primeira aplicação Web configurada (ou a nossa API resetflix convertida no caso :smile:), vamos testar? Para isto inclua esta classe ao seu projeto e vamos executar a nossa API.

```java
@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {
    
    @GetMapping
    public String helloWorld() {
        return "Minha API resetflix está UP!!!";
    }
}
```

> Como executo a minha API? Basta abrir a classe `Aplicacao.java` e clicar no "play" que aparece ao lado do nome da classe no IntelliJ

Após importar a classe e executar o programa, é possível validar se nossa aplicação Web está sendo executada conforme esperado abrindo a seguinte URL no seu Browser: http://localhost:8080/hello-world

---

Último passo, dentro do nosso projeto importado no Intellij, vamos procurar o diretório `src -> main -> resources` e vamos criar um arquivo chamado `application.properties` e dentro dele colar o conteúdo abaixo:

```
server.error.include-message=always
server.error.include-binding-errors=always
```

Esta configuração servirá para apresentar as mensagens de erros configuradas no projeto para quem está chamando os nossos endpoints. As mensagens de erro serão retornadas seguindo o padrão demonstrado abaixo:

```json
{
    "timestamp":"{data hora da requisição}",
    "status":400,
    "error":"Bad Request",
    "message":"{Mensagem de erro da validação}",
    "path":"{pathRelativo}"
}
```

Mas, para que seja retornado corretamente é necessário anotar as classes de erro da sua aplicação com a seguinte anotação:

```java
@ResponseStatus(HttpStatus.BAD_REQUEST)
```

---

## Acabou a moleza :fire:

Com a nossa API configurada, vamos começar a mapear nossos serviços, a final já temos regras de negócio implementadas não é mesmo? :heart_eyes:

Vamos as definições de contratos então para nossas funcionalidades já implementadas:

### Alteração classe domínio

#### Filme

- id
- nome
- anoLancamento
- capaFilme
- List< Genero > generos
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
- Estudio estudio
- List< PersonagemAtor > personagens
- resumo

### 1. Elenco

#### 1.1. Cadastrar ator

- Assinatura
    - `POST /atores`
- Contrato
    - Classe: AtorController | Retorno: void | Método: criarAtor(AtorRequest atorRequest)
- Parâmetros de entrada:
    - AtorRequest
        - nome*
        - dataNascimento*
        - StatusCarreira statusCarreira*
            - EM_ATIVIDADE
            - APOSENTADO
        - anoInicioAtividade*
- Saída esperada em caso de sucesso:
    - Status: `201 CREATED`
    - Body: `N/A`
- Saída esperada em caso de erro:
    - Status: `400 BAD REQUEST`
    - Body: Conforme padrão de erro apresentado no exemplo
- Regras:
    - Mesmas regras definidas na etapa 1

#### 1.2. Listar atores em atividade

- Assinatura
    - `GET /atores/em_atividade`
- Contrato
    - Classe: AtorController | Retorno: List< AtorEmAtividade > | Método: listarAtoresEmAtividade(String filtroNome)
- Parâmetros de entrada:
    - filtroNome (query parameter)
- Saída esperada em caso de sucesso:
    - Status: `200 OK`
    - Body:
        - List< AtorEmAtividade >
            - id
            - nome
            - dataNascimento
- Saída esperada em caso de erro:
    - Status: `400 BAD REQUEST`
    - Body: Conforme padrão de erro apresentado no exemplo
- Regras:
    - Mesmas regras definidas na etapa 1

#### 1.3. Consultar ator

- Assinatura
    - `GET /atores/{id}`
- Contrato
    - Classe: AtorController | Retorno: Ator | Método: consultarAtor(Integer id)
- Parâmetros de entrada:
    - id (path parameter)
- Saída esperada em caso de sucesso:
    - Status: `200 OK`
    - Body:
        - Ator
            - id
            - nome
            - dataNascimento
            - StatusCarreira statusCarreira
                - EM_ATIVIDADE
                - APOSENTADO
            - anoInicioAtividade
- Saída esperada em caso de erro:
    - Status: `400 BAD REQUEST`
    - Body: Conforme padrão de erro apresentado no exemplo
- Regras:
    - Mesmas regras definidas na etapa 1

#### 1.4. Todos os atores

- Assinatura
    - `GET /atores`
- Contrato
    - Classe: AtorController | Retorno: List< Ator > | Método: consultarAtores()
- Parâmetros de entrada:
    - `N/A`
- Saída esperada em caso de sucesso:
    - Status: `200 OK`
    - Body:
        - List< Ator >
            - id
            - nome
            - dataNascimento
            - StatusCarreira statusCarreira
                - EM_ATIVIDADE
                - APOSENTADO
            - anoInicioAtividade
- Saída esperada em caso de erro:
    - Status: `400 BAD REQUEST`
    - Body: Conforme padrão de erro apresentado no exemplo
- Regras:
    - Mesmas regras definidas na etapa 1

### 2. Direção

#### 2.1. Cadastrar diretor

- Assinatura
    - `POST /diretores`
- Contrato
    - Classe: DiretorController | Retorno: void | cadastrarDiretor(DiretorRequest diretorRequest)
- Parâmetros de entrada:
    - DiretorRequest
        - nome*
        - dataNascimento*
        - anoInicioAtividade*
- Saída esperada em caso de sucesso:
    - Status: `201 CREATED`
    - Body: `N/A`
- Saída esperada em caso de erro:
    - Status: `400 BAD REQUEST`
    - Body: Conforme padrão de erro apresentado no exemplo
- Regras:
    - Mesmas regras definidas na etapa 1

#### 2.2. Listar diretores

- Assinatura
    - `GET /diretores`
- Contrato
    - Classe: DiretorController | Retorno: List< Diretor > | listarDiretores(String filtroNome)
- Parâmetros de entrada:
    - filtroNome (query parameter)
- Saída esperada em caso de sucesso:
    - Status: `200 OK`
    - Body:
        - List< Diretor >
            - id
            - nome
            - dataNascimento
            - anoInicioAtividade
- Saída esperada em caso de erro:
    - Status: `400 BAD REQUEST`
    - Body: Conforme padrão de erro apresentado no exemplo
- Regras:
    - Mesmas regras definidas na etapa 1

#### 2.3. Consultar diretor

- Assinatura
    - `GET /diretores/{id}`
- Contrato
    - Classe: DiretorController | Retorno: Diretor | consultarDiretor(Integer id)
- Parâmetros de entrada:
    - id (path parameter)
- Saída esperada em caso de sucesso:
    - Status: `200 OK`
    - Body:
        - Diretor
            - id
            - nome
            - dataNascimento
            - anoInicioAtividade
- Saída esperada em caso de erro:
    - Status: `400 BAD REQUEST`
    - Body: Conforme padrão de erro apresentado no exemplo
- Regras:
    - Mesmas regras definidas na etapa 1

## Acho que ainda está fácil, bora colocar mais lenha nesta fogueira :fire::fire::fire:

### 3. Estúdio

#### 3.1. Cadastrar Estúdio

- Assinatura
    - `POST /estudios`
- Contrato
    - Classe: EstudioController | Retorno: void | Método: criarEstudio(EstudioRequest estudioRequest)
- Parâmetros de entrada:
    - EstudioRequest
        - nome*
        - descricao*
        - dataCriacao*
        - StatusAtividade statusAtividade*
            - EM_ATIVIDADE
            - ENCERRADO
- Saída esperada em caso de sucesso:
    - Status: `201 CREATED`
    - Body: `N/A`
- Saída esperada em caso de erro:
    - Status: `400 BAD REQUEST`
    - Body: Conforme padrão de erro apresentado no exemplo
- Regras:
    - Campos com * são campos obrigatórios
        - Mensagem de erro: "Campo obrigatório não informado. Favor informar o campo {campo}."
    - Não deve ser permitido cadastrar dois estúdios com o mesmo nome
        - Mensagem de erro: "Já existe um estúdio cadastrado para o nome {nome}."
    - A data de criação do estúdio não pode ser superior a data atual
        - Mensagem de erro: "Não é possível cadastrar estúdios do futuro."
    - O id do estúdio deve ser gerado automáticamente de forma sequencial

#### 3.2. Listar Estúdio

- Assinatura
    - `GET /estudios`
- Contrato
    - Classe: EstudioController | Retorno: List< Estudio > | Método: consultarEstudios(String filtroNome)
- Parâmetros de entrada:
    - filtroNome (query parameter)
- Saída esperada em caso de sucesso:
    - Status: `200 OK`
    - Body:
        - List< Estudio >
            - id
            - nome
            - descricao
            - dataCriacao
            - StatusAtividade statusAtividade
                - EM_ATIVIDADE
                - ENCERRADO
- Saída esperada em caso de erro:
    - Status: `400 BAD REQUEST`
    - Body: Conforme padrão de erro apresentado no exemplo
- Regras:
    - O campo filtroNome é opcional, quando informado deve filtrar por qualquer match na sequência do nome, 
        Exemplo: filtroNome -> vel
                estúdio encontrado -> Marvel Studios
    - Caso não exista nenhum estúdio cadastrado deve retornar erro
        - Mensagem de erro: "Nenhum estúdio cadastrado, favor cadastar estúdios."
    - Caso não seja encontrado nenhum estúdio com o filtro informado deve retornar erro
        - Mensagem de erro: "Estúdio não encontrato com o filtro {filtro}, favor informar outro filtro."

#### 3.3. Consultar Estúdio

- Assinatura
    - `GET /estudios/{id}`
- Contrato
    - Classe: EstudioController | Retorno: Estudio | Método: consultarEstudio(Integer id)
- Parâmetros de entrada:
    - id (path parameter)
- Saída esperada em caso de sucesso:
    - Status: `200 OK`
    - Body:
        - Estudio
            - id
            - nome
            - descricao
            - dataCriacao
            - StatusAtividade statusAtividade
                - EM_ATIVIDADE
                - ENCERRADO
- Saída esperada em caso de erro:
    - Status: `400 BAD REQUEST`
    - Body: Conforme padrão de erro apresentado no exemplo
- Regras:
    - O filtro id é obrigatório
        - Mensagem de erro: "Campo obrigatório não informado. Favor informar o campo {campo}."
    - Deve retornar o estúdio filtrado pelo id
    - Caso não encontrado o estúdio, deve retornar erro
        - Mensagem de erro: "Nenhum estúdio encontrado com o parâmetro id={}, favor verifique os parâmetros informados."

### 4. Filmes

#### 4.1. Cadastrar Filmes

- Assinatura
    - `POST /filmes`
- Contrato
    - Classe: FilmeController | Retorno: void | Método: criarFilme(FilmeRequest filmeRequest)
- Parâmetros de entrada:
    - FilmeRequest
        - nome*
        - anoLancamento*
        - capaFilme*
        - List< Genero > generos
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
        - idDiretor*
        - idEstudio*
        - resumo*
        - List< PersonagemRequest > personagens*
            - idAtor*
            - nomePersonagem*
            - descricaoPersonagem*
            - TipoAtuacao tipoAtuacao
                - PRINCIPAL
                - COADJUVANTE
- Saída esperada em caso de sucesso:
    - Status: `201 CREATED`
    - Body: `N/A`
- Saída esperada em caso de erro:
    - Status: `400 BAD REQUEST`
    - Body: Conforme padrão de erro apresentado no exemplo
- Regras:
    - Campos com * são campos obrigatórios
        - Mensagem de erro: "Campo obrigatório não informado. Favor informar o campo {campo}."
    - Caso não exista nenhum estúdio cadastrado para o id informado deve retornar erro
        - Mensagem de erro: "Nenhum estúdio encontrado com o parâmetro id={}, favor verifique os parâmetros informados."
    - Caso não exista nenhum diretor cadastrado para o id informado deve retornar erro
        - Mensagem de erro: "Nenhum diretor encontrado com o parâmetro id={}, favor verifique os parâmetros informados."
    - Caso não exista nenhum ator cadastrado para o id informado deve retornar erro
        - Mensagem de erro: "Nenhum ator encontrado com o parâmetro id={campo}, favor verifique os parâmetros informados."
    - Não é permitido cadastrar filmes que apresentem duas vezes o mesmo gênero na lista informada na requisição, caso encontrado gêneros duplicados deve retornar mensagem de erro, exemplo:
        - List< Generos > generos : ["ACAO", "TERROR", "COMEDIA", "ACAO"] | não permitido
        - List< Generos > generos : ["ACAO", "TERROR", "COMEDIA", "ESPIONAGEM"] | permitido
        - Mensagem de erro: "Não é permitido informar o mesmo gênero mais de uma vez para o mesmo filme."
    - Não é permitido cadastrar o mesmo personagem com o mesmo ator mais de uma vez, caso seja informado o mesmo ator para o mesmo personagem deve retornar erro, exemplo:
        - List< PersonagemRequest > personagens : [{"idAtor": 1, "nomePersonagem": "meu personagem"}, {"idAtor": 2, "nomePersonagem": "outro personagem"}, {"idAtor": 1, "nomePersonagem": "meu personagem"}] | não permitido
        - List< PersonagemRequest > personagens : [{"idAtor": 1, "nomePersonagem": "meu personagem"}, {"idAtor": 2, "nomePersonagem": "outro personagem"}, {"idAtor": 3, "nomePersonagem": "meu personagem"}] | permitido
        - Mensagem de erro: "Não é permitido informar o mesmo ator/personagem mais de uma vez para o mesmo filme."
    - Os ids do filme e do personagem devem ser gerados automáticamente de forma sequencial

#### 4.2. Consultar Filmes

- Assinatura
    - `GET /filmes`
- Contrato
    - Classe: FilmeController | Retorno: List< Filme > | Método: consultarFilmes(String nomeFilme, String nomeDiretor, String nomePersonagem, String nomeAtor)
- Parâmetros de entrada:
    - nomeFilme (query parameter)
    - nomeDiretor (query parameter)
    - nomePersonagem (query parameter)
    - nomeAtor (query parameter)
- Saída esperada em caso de sucesso:
    - Status: `200 OK`
    - Body:
        - List< Filme >
            - id
            - nome
            - anoLancamento
            - capaFilme
            - List< Genero > generos
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
            - Estudio estudio
            - List< PersonagemAtor > personagens
            - resumo
- Saída esperada em caso de erro:
    - Status: `400 BAD REQUEST`
    - Body: Conforme padrão de erro apresentado no exemplo
- Regras:
    - Todos os parâmetros de filtro são opcionais, e devem retornar qualquer match na sequência dos seus referentes campos
        - nomeFilme -> Classe Filme | Campo nome
        - nomeDiretor -> Classe Diretor | Campo nome
        - nomePersonagem -> Classe PersonagemAtor | Campo nomePersonagem
        - nomeAtor -> Classe Ator | Campo nome
    - Caso não encontrado nenhum filme para os filtros informados deve retornar erro
        - Mensagem de erro: "Ator não encontrato com os filtros nomeFilme={nomeFilme}, nomeDiretor={nomeDiretor}, nomePersonagem={nomePersonagem}, nomeAtor={nomeAtor}, favor informar outros filtros."
    - Caso não exista nenhum filme cadastrado, deve retornar erro
        - Mensagem de erro: "Nenhum filme cadastrado, favor cadastar filmes."

## Lembretes

**Os contratos especificados no exercício devem ser respeitados, caso alguma nomenclatura especificada seja alterada, os instrutores e monitores podem solicitar o ajuste. Caso o ajuste não seja realizado, não será garantido uma avaliação do exercício proposto.**

**IMPORTANTE**: As classes entregues como exemplo neste arquivo não contém os imports, para o correto funcionamento da aplicação, deve ser complementado com os imports específicos ao copiar a classe para o projeto.

Para esta etapa vamos alterar nossa base de dados em memória da a classe `FakeDatabase.java` criada na etapa 1 para a seguinte estrutura:

```java
public class FakeDatabase {

    private static FakeDatabase fakeDatabase = new FakeDatabase();

    public static FakeDatabase getInstance() {
        return fakeDatabase;
    }

    private FakeDatabase() {
    }

    private List<Ator> atores = new ArrayList<>();
    private List<Diretor> diretores = new ArrayList<>();
    private List<Estudio> estudios = new ArrayList<>();
    private List<Filme> filmes = new ArrayList<>();
    private List<PersonagemAtor> personagens = new ArrayList<>();

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

    public void persisteEstudio(Estudio estudio) {
        estudios.add(estudio);
    }

    public List<Estudio> recuperaEstudios() {
        return estudios;
    }

    public void persisteFilme(Filme filme) {
        filmes.add(filme);
    }

    public List<Filme> recuperaFilmes() {
        return filmes;
    }

    public void persistePersonagem(PersonagemAtor personagemAtor) {
        personagens.add(personagemAtor);
    }

    public List<PersonagemAtor> recuperaPersonagens() {
        return personagens;
    }
}

```

E nas nossas controllers, vamos fazer a referência as nossas services conforme exemplo da `AtorController.java` apresentada abaixo:

```java
@RestController
@RequestMapping("/atores")
public class AtorController {

    private AtorService atorService;

    public AtorController() {
        this.atorService = new AtorService(FakeDatabase.getInstance());
    }

    //demais métodos
}
```