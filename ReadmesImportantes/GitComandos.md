# Git Básico

## O que é
O Git é uma ferramenta de versionamento distribuído de código mais usado do mundo. Permite salvar, ter histórico
e integrar o trabalho de difertentes colaboradores, permitindo criar diferentes versões do mesmo código 
e uni-las quando necessário tendo.

## Remoto vs Local
O código fica salvo tanto no servidor central (*gitlab, github, etc*) quanto distribuído na máquina de cada desenvolvedor.
Todo mundo tem uma cópia do código em sua máquina. Existem comandos que permitem atualizar a versão 
local trazendo as novidades do servidor (*git pull*) ou ainda atualizar o servidor com as novas alterações feitas 
na máquina do desenvolvedor (*git push*).

## Comandos Básicos

* ```git clone <url-repositório>```=> ``` git clone https://github.com/repositorio-qualquer/edicao-03-level-2.git ```
  
  Faz uma cópia do repositório remoto para a máquina do desenvolvedor. Ou seja, todos os arquivos presentes no repositório em questão
serão "baixados" para sua máquina.


* ``` git add <caminho> ```  => ``` git add . ```

     Seleciona quais arquivos alterados ou criados o desenvolvedor devem ser considerados para enviar ao servidor.
  
     Diferença entre os comandos  
     * **git add < caminho >**  Adicionar o arquivo que esta após o add.  
     * **git add .** adiciona todas as alterações de uma única vez, ou seja, o ponto significa "todos 
    os arquivos alterados ou criados".


* ```  git commit -m "<mensagem>"``` => ```git commit -m "Cria a nova tela de cadastro de produtos" ```

   Empacota as alterações selecionadas com o git add e cria um "checkpoint", ou seja, um conjunto de
  alterações que desempenham uma função.


* ``` git push```

   Submete todos os commits feitos anteriormentes, enviando-os ao servidor remoto para que fique disponível 
  para os demais desenvolvedores.


* ```git pull```

   Atualiza o código local, trazendo as alterações feitas no servidor remoto por outros desenvolvedores.


* ``` git status```
  
  Este comando apresenta todos os arquivos que você alterou ou adicionou no projeto, ele também informa se
  o repositório remoto possui commits a frente do repositório local ou se você possui commits a frente do repositório remoto.


* **IMPORTANTE**
   Utilizar os comandos sem os "< >"


##  Programação Básica

###  Variáveis


- Como o nome já diz, são símbolos cujo o valor pode variar;

- No Java as variáveis são tipadas, ou seja, trabalham com dados do tipo especificado em sua declaração.







###  Tipos de Dados



####  Tipos primitivos



- int => 1

- double => 1.23

- boolean => true | false

- void => nada



####  Tipos por referência



- String

- Integer

- Double

- Boolean

- BigDecimal

- LocalDate

- LocalTime


###  Comentários



- Adicionar alguma informação que **não** será interpretada pelo compilador;

- Utilizados para documentação de código, ou apenas como recurso para sinalizar algum trecho que deva ser revisado antes de submeter ao ambiente remoto do repositório;


#### Comentário por linha
~~~java

// comentário em uma linha

// comentário em outra linha
~~~

#### Comentar mais de uma linha
~~~java
/*

bloco de comentário

nada aqui será considerado

*/

~~~


###  Operadores



#### Operadores aritméticos

| Operador | Descrição     |  Cenário | Resultado |
| :------: | ------------- | -------: | :-------- |
|   `+`    | Soma          | `10 + 2` | `12`      |
|   `-`    | Subtração     | `10 - 2` | `8`       |
|   `*`    | Multiplicação | `10 * 2` | `20`      |
|   `/`    | Divisão       | `10 / 2` | `5`       |
|   `%`    | Módulo        | `10 % 2` | `0`       |

#### Operadores de Atribuição

| Operador | Descrição |         Cenário | Resultado                            |
| :------: | --------- | --------------: | :----------------------------------- |
|   `=`    | Simples   | `contador = 10` | `contador` agora possui o valor `10` |

#### Operadores de Incremento

| Operador | Descrição     |          Cenário | Resultado                              |
| :------: | ------------- | ---------------: | :------------------------------------- |
|   `++`   | Incremento    |     `contador++` | o mesmo que `contador = contador + 1`  |
|   `--`   | Decremento    |     `contador--` | o mesmo que `contador = contador - 1`  |
|   `+=`   | Soma          | `contador += 10` | o mesmo que `contador = contador + 10` |
|   `-=`   | Subtração     | `contador -= 10` | o mesmo que `contador = contador - 10` |
|   `*=`   | Multiplicação | `contador *= 10` | o mesmo que `contador = contador * 10` |
|   `/=`   | Divisão       | `contador /= 10` | o mesmo que `contador = contador / 10` |
|   `%=`   | Módulo        | `contador %= 10` | o mesmo que `contador = contador % 10` |

#### Operadores de Igualdade

| Operador | Descrição    | Cenário 1 | Resultado 1 |  Cenário 2 | Resultado 2 |  Cenário 3 | Resultado 3 |
| :------: | ------------ | --------: | :---------- | ---------: | :---------- | ---------: | :---------- |
|   `==`   | Igual a      | `9 == 10` | `false`     | `10 == 10` | `true`      | `11 == 10` | `false`     |
|   `!=`   | Diferente de | `9 != 10` | `true`      | `10 != 10` | `false`     | `11 != 10` | `true`      |

#### Operadores Relacionais

| Operador | Descrição        | Cenário 1 | Resultado 1 |  Cenário 2 | Resultado 2 |  Cenário 3 | Resultado 3 |
| :------: | ---------------- | --------: | :---------- | ---------: | :---------- | ---------: | :---------- |
|   `>`    | Maior que        |  `9 > 10` | `false`     |  `10 > 10` | `false`     |  `11 > 10` | `true`      |
|   `<`    | Menor que        |  `9 < 10` | `true`      |  `10 < 10` | `false`     |  `11 < 10` | `false`     |
|   `>=`   | Maior ou igual a | `9 >= 10` | `false`     | `10 >= 10` | `true`      | `11 >= 10` | `true`      |
|   `<=`   | Menor ou igual a | `9 <= 10` | `true`      | `10 <= 10` | `true`      | `11 <= 10` | `false`     |

#### Operadores Lógicos

|         Operador          | Descrição                                      |                           Cenário 1 | Resultado 1 |                            Cenário 2 | Resultado 2 |                             Cenário 3 | Resultado 3 |
| :-----------------------: | ---------------------------------------------- | ----------------------------------: | :---------- | -----------------------------------: | :---------- | ------------------------------------: | :---------- |
|            `!`            | Negação - inverte o valor booleano             |                            `!false` | `true`      |                              `!true` | `false`     |                         `!(10 == 10)` | `false`     |
|           `&&`            | E lógico - true se ambos argumentos forem true |                      `true && true` | `true`      |                      `true && false` | `false`     |                      `false && false` | `false`     |
| <code>&#124;&#124;</code> | OU lógico - true se um dos argumentos for true | <code>true &#124;&#124; true</code> | `true`      | <code>true &#124;&#124; false</code> | `true`      | <code>false &#124;&#124; false</code> | `false`     |

## Comandos de condição
### if/else

```if/else``` é uma estruturas que condiciona ao programa a tomada de decisões em tempo de execução, possibilitando seguir fluxos diferentes.
Com este comando dizemos ao programa "Faça a instrução A caso a condição X seja verdadeira, caso contrário, execute a instrução B".

~~~java
if (condição booleana) {
    // instrução A
} else {
    // instrução B
}
~~~

É normal a necessidade de usar mais condições em nosso programa, com isso podemos adicionar elses a estrutura ```if/else```
~~~java
if (expressão booleana 1) {
// instrução A
} else if (expressão booleana 2) {
// instrução B
} else if (expressão booleana 3) {
// instrução C
} else {
// instrução D
}
~~~

### If ternário
Este comando realiza a mesma decisão que o ```if/else```, porém em apenas uma linha;
~~~java
(expressão booleana) ? retorna o valor 1 : retorna o valor 2;
~~~
*Obs.: caso a condição seja verdadeira, retorna o valor após o ```?```, caso contrário retorna o valor após os ```:```*

## Laços de repetição ou Loop

A estruturas de repetições são utilizadas quando precisamos executar um bloco de código por diversas vezes, ou seja,
repetir o mesmo código quantas vezes você quiser, abaixo iremos explicar a estrutura de repetição ```for``` e ```while```

### For

Esta é a estrutura do código
```java
for(int i = 0; i <= 10; i++) {
    System.out.println(i);
}
```

Podemos dividir ela em três partes:
```java
for(parte1, parte2, parte3) {
    //Código a ser executado
}
```

>  **parte 1:** é onde nós declaramos uma variável e o seu valor inicial.
>
>  **parte 2:** é onde nós colocamos uma condição para que continue ou seja terminado. A condição a ser estabelecida pode ser qualquer uma, porém, é comum e recomendável colocar uma condição utilizando a variável ou variáveis declaradas da **parte 1**.
>
>  **parte 3:** é onde nós incrementamos ou decrementamos a nossa variável da **parte 1**, e comparamos na **parte 2**.

*Obs: Sempre que a **parte 2** for verdadeira, o código irá executar, quando ela for falsa, o for termina.*


### While

Este comando funciona a partir de uma condição que quando verdadeira, executa o que tem no ```//bloco de código``` 
e quando for falsa, cairá fora do while.


 ```java
int i = 0;
while(condição A){
    //bloco de código
    alterar a condição A
}
```

Estrutura do código

 ```java
int i = 1;
while(i<=9){
    System.out.println(i);
    i++;
}
```

Analisando o código acima vemos que 
* A nossa condição é ``i<=9``(parâmetro do while)
* Sempre que a condição for verdadeira será imprimido o ``i`` através do comando ```System.out.println(i);```
* Sempre que a condição for verdadeira será incrementado ```1``` em nossa condição.

Com isso nosso código executará ```9```  vezes e na décima vez cairá fora.

*Obs.: Na estrutura while devemos sempre ter a possibilidade para que a nossa ```condição A````uma hora seja falsa
para que o while não entre em um loop infinito*





