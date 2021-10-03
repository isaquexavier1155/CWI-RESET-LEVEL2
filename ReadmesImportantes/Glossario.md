# Glossário

## Versionamento

- **Versionamento**: técnica de desenvolvimento que permite salvar cada pequena alteração, criando um histórico navegável de todas alterações. Permite recuperar o que foi feito em uma data específica ou funcionalidade específica. Atualmente, todo projeto profisisonal usa alguma ferramenta de versionamento.
- **Commit**: conjunto de alterações que desempenham uma funcionalidade específica da aplicação. Se aplica ao contexto do Git
- **Git**: ferramenta de versionamento de código fonte, permite criar várias versões e ramificações do código da aplicação. Principais comandos Git:
    - `git clone <url-repositorio>`: baixa os fontes do servidor remoto criando um vínculo entre máquina local e servidor
    - `git status`: exibe o estado atual das alterações **locais**
    - `git add <path>`: seleciona os arquivos que serão considerados no próximo pacote de alterações
    - `git commit -m "<mensagem>"`: fecha um pacote de alterações dando uma mensagem de identificação a ele
    - `git push`: envia todos os commits (pacotes de alterações) para o servidor remote
    - `git pull`: baixa todas os commits (pacotes de alterações) do servidor remote
    - `git status`: apresenta no terminal os pacos que foram alterados/criados.
- **GitHub**: repositório de código fonte, onde são guardados e compatilhados projetos utilizando Git.
- **WIP**: Acrônimo de "Work in Progress", é usado para indicar que o trabalho ainda não foi terminado, mas mesmo assim foi feito o push para o repositório.
- **Merge**: Significa "mesclar". É usado quando temos 2 branches e precisamos juntar em apenas 1.
- **MR (Merge Request)**: É uma solicitação de merge entre 2 branches. Dentro da solicitação é possível adicionar comentários, questionamentos, revisar as alterações entre outras interações.
- **PR (Pull Request)**: É o mesmo que Merge Request. Algumas ferramentas usam MR, outras PR.

## Programação

- **Booleano**: lógica, valor ou expressão que possui apenas dois resultados possíveis: verdadeiro ou falso
- **Operador**: assim como na matemática, são símbolos utilizados para desempenhar funcões aritméticas, lógicas, entre outras
- **Tipo** de Dado: termo utilizado para designar o comportamento e/ou a estrutura de uma variável
- **Tipos Primitivos**: tipos de dados simplificados. Não possuem comportamentos (métodos) e apenas guardam informações simples como um número ou booleano
- **Variável**: símbolo ou termo usado no código que guarda um valor de um tipo específico. O valor pode ser alterado ao longo da execução, o tipo não
- **Valor**: informação/conteúdo de uma variável ou atributo
- **Manutenibilidade**: caracteristica de um código ou sistema que indica o quão simples é dar manutenção no sistema em questão. É desejável que os sistemas que desenvolvemos não somente funcionem, mas que sejam manuteníveis, para que as próximas alterações no sistema não sejam caras e dolorosas.
- **Reativo**: é um modelo ou um paradigma de programação orientado a fluxo de dados e propagações de estados
- **Funcional**: é um paradigma de programação que trata a computação como uma avaliação de funções matemáticas e que evita estados ou dados mutáveis.

### Comandos
- **if/else**: Comando para tomada de decições.
- **if ternário**: Executa o mesmo que o **if/else** porém em uma linha.
- **for** e **while**: estruturas de laços de repetições para que executem um determinado código quantas vezes for determinado pela(o) programadora(o).

## Java

- **Java**: linguagem de programação de alto nível e fortemente tipada, o que significa que todas as variáveis e atributos precisar ter seus tipos de dados definidos de forma explícita.
- **JDK**: Abreviação de Java Development Kit. É um conjunto de ferramentas que incluem o compilador e permitem o desenvolvimento de aplicações Java.
- **JRE**: Abreviação de Java Runtime Environment. É a ferramenta necessária para executar aplicações desenvolvidas em Java, e inclui a JVM além de outras ferramentas.
- **JVM**: Abreviação de Java Virtual Machine. É um software instalado no computador capaz de interpretar o código compilado e transcrevê-lo em linguagem de máquina de acordo com o o sistema operacional em execução.

## Ferramentas

- **IDE**: abreviação de Integrated Development Environment ou Ambiente de Desenvolvimento Integrado, é um programa de computador que reúne características e ferramentas de apoio ao desenvolvimento de software com o objetivo de agilizar este processo.
- **Intellij**: é uma IDE desenvolvida pela JetBrains bastante utilizada no desenvolvimento de aplicações Java.
- **Projeto**: conjunto de classes que criam uma ou mais aplicações que desempenham uma função. No Intellij pode ser criado em `File > New Project` ou importado em `File > Open (selecionando pasta do projeto)`.
- **Slack**: ferramente de comunicação que visa subsituir o e-mail. Permite criar grupos de conversas por assuntos e conversas diretas entre participantes.
- **Ant**: é uma ferramenta utilizada para automação de compilação na construção de software
- **Maven**:  é uma ferramenta de automação de compilação utilizada primariamente em projetos Java. Ela é similar à ferramenta Ant, mas é baseada em conceitos e trabalhos diferentes em um modo diferente.
- **Gradle**: é um sistema de automação de compilação de código aberto que se baseia nos conceitos de Apache Ant e Apache Maven e introduz uma linguagem de domínio específico baseada em Groovy em vez do XML usado pelo Apache Maven para declarar a configuração do projeto
- **Docker**: é um conjunto de produtos de plataforma como serviço que usam virtualização de nível de sistema operacional para entregar software em pacotes chamados contêineres. Os contêineres são isolados uns dos outros e agrupam seus próprios softwares, bibliotecas e arquivos de configuração.

## Orientação a Objetos

- **Programação Orientada a Objetos**: também connhecida como OO, é um paradigma de programação, um jeito de escrever código. Prega que o código deve representar o contexto real através de objetos que abstraem a complexidade de tarefas específicas.
  > Objetos são como pessoas. Eles estão vivendo, respirando, realizando ações que têm conhecimento, além de possuírem memória dentro deles para que possam se lembrar de coisas. E ao invés de interagir com eles em um nível muito baixo, você interage com eles em um nível muito alto de abstração, como estamos fazendo aqui. Aqui está um exemplo: se eu sou seu objeto de lavanderia, você pode me dar sua roupa suja e enviar-me uma mensagem que diz: "Você pode pegar minhas roupas lavadas, por favor." Acontece que eu sei onde fica a melhor lavanderia em San Francisco. Eu falo inglês e tenho dólares nos bolsos. Então, eu saio, chamo um táxi e digo ao motorista para me levar a este lugar em San Francisco. Eu pego suas roupas lavadas, entro novamente no táxi e volto aqui. Eu lhe entrego suas roupas limpas e digo: "Aqui estão suas roupas limpas". Você não tem ideia de como eu fiz isso. Você não tem conhecimento do lugar da lavanderia. Talvez você fale francês e não pode sequer chamar um táxi. Você não pode pagar por não ter dólares no bolso. Mas eu sabia como fazer tudo isso. E você não tem que saber de nada disso. Toda essa complexidade estava escondida dentro de mim e fomos capazes de interagir em um nível muito alto de abstração. Isso é o que são objetos. Eles encapsulam a complexidade e as interfaces para que esta complexidade esteja em alto nível (de abstração). Por Steve Jobs.
- **Objeto**: algum elemento do contexto que estamos querendo reproduzir em código. Um objeto pode ser uma Pessoa, um Animal, um Carro, uma Conta, um Gerenciador, um Emissor de Nota Fiscal, enfim. "Um objeto é uma instância de um tipo de objeto", MARTIN, 1994
- **Classe**: é a definição de como um objeto se comporta. Atenção aqui ao termo **definição**, que no dicionário significa "delimitação exata, estabelecimento de limites". Ou seja, um mesmo objeto pode ter definições diferentes de acordo com o contexto no qual ele é aplicado. Pense nas características de um carro. Entre as diversas características de um carro, podemos dizer que ele possui um dono, certo? Então podemos ter uma classe `Carro` que possui um atributo `dono`. Mas e se estivermos falando de uma loja de carros novos? O atributo `dono` faz algum sentido? Sendo assim, o objeto carro pode ser definido de formas diferentes, por classes diferentes, de acordo com o contexto no qual ele é inserido.
- **Instância**: representa, em código, um objeto criado a partir de uma classe. A intância é o resultado do operador `new`. O valor de uma variável, é uma instância do tipo dessa variável. No exemplo `Mago patologica = new Mago("Maga Patológica")`, temos que `Mago` é a classe; `patologica` é a variável; e o **valor** da variável `patologica` é uma **instância** de `Mago`. E onde, nesse exemplo, está o **objeto**? O objeto transcende o código, ele é a própria representação do contexto. Posso dizer que eu tenho, nesse exemplo, um **objeto** _mago_, definido pela **classe** `Mago`.
- **Atributo**: atributo é uma variável da classe. Ou seja, é uma característica de um objeto expressa em código através de uma variável definida em uma classe. A cor de um carro, por exemplo, pode ser representada pelo atributo `cor` na classe `Carro`.
- **Método**: são as funções ou ações que um objeto pode fazer. Se um carro é capaz de ligar (e essa informação é importande no nosso cenário), então precisamos de um método `ligar`, que nada mais é do que uma função específica de uma classe. Métodos podem possuir um retorno e parâmetros.
- **Construtor**: é um tipo especial de método de uma classe que é invocado quando uma classe é instanciada. Quando usamos o operador `new` estamos invocando um construtor da classe que será responsável por inicializar o estado daquela instância.
- **Parâmetro**: um método pode possuir parâmetros, que são variáveis que ele aceita que serão úteis para desempenhar a função desejada. Se temos um método que soma dois números, precisamos definir que esse método possui 2 parâmetros. São um tipo especial de variável, que existem apenas dentro do escopo do método e podem ter seu valor definido por quem invoca o método.
- **Argumento**: o argumento é o valor de um parâmetro de um método. Quando invocamos um método que possui parâmetros, precisamos definir o valor deles, esse valor é o argumento. No exemplo `double andar(double velocidade, double aceleracao, int segundos)`, temos um **método** `andar`, que possui três **parâmetros**. Ao executarmos esse método `carro.andar(0.0, 10.0, 5)`, estamos passando `0.0`, `10.0` e `5` como **arguementos** do método.
- **Retorno de método**: é o valor de resultado da execução desse método. Quando invocado, o método poderá produzir um resultado e esse resultado chamamos de retorno.
- **Invocar**: Ação de executar ou chamar um método. Um método pode ser chamado ou executado ou invocado - são sinônimos.
- **Acoplamento**: O acoplamento significa o quanto uma classe depende da outra para funcionar. E quanto maior for esta dependência entre ambas, dizemos que tais classes estão fortemente acopladas. O objetivo sempre será ter um código menos acoplado possível.

## Escrita

- **Case**: é o padrão de escrita de texto, que define o padrão de caracteres para escritas de texto. Ligado principalmente a letras maiúsculas e minúsculas.
- **Case Sensitive**: Indica que, para um determinado sistema ou ambiente, a diferença de letras maiúsculas e minúsculas faz diferença para o sistema. Dizemos que Java é **case sensitive** por que ele considera que, por exemplo, a variável `velocidade` é diferente da variável `Velocidade` ou `velocidadE`.
- **UpperCase**: Modo de escrever onde são usadas apenas letras maiúsculas. `TEXTO`. Também conhecida como **PascalCase**.
- **LowerCase**: Modo de escrever onde são usadas apenas letras minúsculas. `texto`.
- **CamelCase**: Modo de escrever onde são usadas apenas letras minúsculas, porém, quando existem mais deuma palavra, as palavras subsequentes à primeira possuem a primeira letra maiúscula. `textoAdicional`. Possui duas variações, que é o `LowerCamelCase`, que é o mesmo que `CamelCase`; e o `UpperCamelCase`, onde todas as palavras começam com maiúsculo, inclusive a primeira: `TextoAdicional`.
- **Indentação**: São os recuos no texto de um código usados para organizar visualmente, melhorar a leitura, separando escopos que são aninhados.
- **Comentário**: trecho de código ignorado pelo compilador, feito por humanos para humanos. Serve para adicionar clareza a um trecho complexo e de difícil entendimento.

## Infraestrutura

- **Cluster**: é um termo em inglês que significa "aglomerar" ou "aglomeração" e pode ser aplicado em vários contextos. No caso da computação, o termo define uma arquitetura de sistema capaz combinar vários computadores para trabalharem em conjunto ou pode denominar o grupo em si de computadores combinados.
- **Integração Contínua / Continous Integration / CI**: é uma prática recomendada ágil e de DevOps para integrar, como parte da rotina, alterações de código na branch principal de um repositório e testar as alterações com o máximo de antecedência e frequência possível.
- **Entrega Contínua / Continuous Delivery / CD**: é uma abordagem na qual os times de desenvolvimento lançam produtos de qualidade de forma frequente, previsível e automatizada. Em vez de fazer grandes entregas de uma vez, fazem várias pequenas e rápidas — reduzindo as chances de erros e conquistando maior controle de qualidade
- **Pipeline**: Um pipeline de CI/CD consiste em uma série de etapas a serem realizadas para a disponibilização de uma nova versão de um software. Os pipelines de integração e entrega contínuas (CI/CD) são uma prática que tem como objetivo acelerar a disponibilização de softwares, adotando a abordagem de DevOps ou de engenharia de confiabilidade de sites (SRE).
- **DevOps**: é uma cultura na engenharia de software que aproxima os desenvolvedores de software (Dev) e os operadores do software / administradores do sistema (Ops), com característica principal de melhorar a comunicação dos dois papéis dentro de um projeto e defender a automação e monitoramento em todas as fases da construção de um software (desde a integração, teste, liberação para implantação, ao gerenciamento de infraestrutura), auxiliam empresas no gerenciamento de lançamento de novas versões, padronizando ambientes em ciclos de desenvolvimento menores, frequência de implantação aumentada, liberações mais seguras, em alinhamento próximo com os objetivos de negócio.
- **Deploy**: traduz-se para implantação. É a fase do ciclo de vida de um software que corresponde à passagem do software para a produção, ou seja, a liberação de uma versão para uso pelo usuário final. Pode ser usada também em outros ambientes, além do produtivo. 
- **Produção / Desenvolvimento / Homologação**: são os ambientes onde um software é disponibilizado. O ambiente de desenvolvimento pode ser a máquina local do desenvolvedor ou ainda um ambiente para disponibilziar diversas partes do software com o objetivo de validar a integração entre elas antes de promover para os demais ambientes. Homologação normalmente é usado pelo usuário que solicitou a demanda, com o objetivo de validar se o que foi entregue está coerente com o que foi solicitado. Pode ser usado também pelo time de qualidade. Produção é o ambiente principal, onde o software é usado efetivamente pelos usuários finais.
- **Gateway**: O gateway de API é uma ferramenta de gerenciamento de APIs que fica entre o cliente e uma coleção de serviços de back-end
- **Virtualização**: é a capacidade de criar um computador virtual no seu PC, permitindo instalar sistema operacional, rodar programas e realizar tarefas. 
- **VPN**: do inglês Virtual Private Network (VPN), é uma rede de comunicações privada construída sobre uma rede de comunicações pública (como por exemplo, a Internet). O tráfego de dados é levado pela rede pública utilizando protocolos padrões, não necessariamente seguros. Em resumo, cria uma conexão segura e criptografada, que pode ser considerada como um túnel, entre o seu computador e um servidor operado pelo serviço VPN

## Processo

- **Sprint**: é um evento que contém todos os demais eventos do Scrum: Sprint Planning, Daily Scrum, Sprint Review e Sprint Retrospective. A Sprint é o coração do Scrum, além de executar os eventos citados, é ao final dela que um incremento "Pronto" é criado num estado que chamamos potencialmente lançável.
- **Sprint Planning**: O Sprint Planning é uma reunião na qual estão presentes o Product Owner (PO), o Scrum Master (SM) e todo o Scrum Team, bem como qualquer pessoa interessada que esteja representando a gerência ou o cliente. Durante o Sprint Planning Meeting, o PO descreve as funcionalidades de maior prioridade para a equipe. A equipe faz perguntas durante a reunião de modo que seja capaz de quebrar as funcionalidades em tarefas técnicas, após a reunião. Essas tarefas irão dar origem ao Sprint Backlog
- **Backlog**: é uma lista de atividades que precisam ser feitas durante uma sprint.
- **Daily**: a Daily Scrum, também chamada de Daily, Daily Meeting ou Reunião Diária, é um evento que acontece diariamente, possui um time-box de 15 minutos, que independe do tamanho do time ou do tamanho da Sprint. Seu propósito é que o Time de Desenvolvimento realize inspeção e adaptação sobre o plano de trabalho necessário para atingir o Sprint Goal (Objetivo da Sprint) definido no planejamento.
- **Review**: A Sprint Review é o penúltimo evento da Sprint, geralmente acontece no seu último dia e tem por objetivo a inspeção do Incremento de Produto desenvolvido naquela Sprint e adaptação do Product Backlog caso necessário. Esse é o único evento no qual, por definição, temos a participação de pessoas externas ao Time Scrum
- **Retrospectiva**: A Retrospectiva da Sprint (ou Sprint Retrospective) é o evento que fecha a Sprint que é um ciclo de desenvolvimento de produto no Scrum. Esse é o momento no qual o time se dedica à inspecionar o seu trabalho, avaliando como foi a última Sprint e cria um plano de ação para a próxima. 
- **Refinamento**: é um processo contínuo no qual o proprietário do produto e a equipe de desenvolvimento colaboram para garantir que os itens no Backlog do Produto: são entendidas da mesma forma por todos os envolvidos (entendimento compartilhado), possuem uma estimativa de tamanho para a complexidade (relativa) e o esforço de sua implementação, e são ordenados de acordo com sua prioridade em termos de valor comercial e esforço necessário. Resumindo: Refinamento de Backlog é criar um entendimento compartilhado sobre o que o Produto fará e não fará, sobre o esforço necessário para implementá-lo, e a ordem na qual você fará isso.
- **POC**: do inglês, Proof of Concept ou Prova de Conceito. É um modelo prático que tenta provar o conceito teórico estabelecido por uma pesquisa ou artigo técnico, ou é uma implementação, em geral resumida ou incompleta, de um método/idéia, realizado com o propósito de verificar que o conceito/teoria em questão é suscetível de ser explorado de uma maneira útil. Sendo um passo importante no processo de criação de um protótipo realmente operativo.
- **MVP**: é a sigla para Minimum Viable Product (ou Produto Mínimo Viável), um conceito criado por startups e integrado a outros segmentos. Com baixo custo, o modelo MVP deve ser implementado com foco nos objetivos do cliente e nas demandas definidas durante o planejamento do projeto.
- **Stakeholder**:  significado da palavra "Stakeholder" a junção de "stake" que significa: Interesse, participação, risco e "holder" aquele que possui. Refere-se as pessoas que têm interesse na Gestão do Projeto ou na Gestão da Empresa. Os Stakeholders são peça fundamental de apoio a organização e também devem ser considerados na tomada de decisão de uma empresa. Eles podem ser internos ou externos. Alguns exemplos de interessados são: colaboradores, clientes, fornecedores e acionistas.
