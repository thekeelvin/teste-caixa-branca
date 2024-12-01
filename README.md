# **Documentação do Projeto - Caixa Branca**

## Objetivo

O objetivo desta etapa foi a documentação do código-fonte do projeto, utilizando o **Javadoc** para gerar uma documentação técnica detalhada. Além disso, foram feitos comentários explicativos no código-fonte, visando melhorar a compreensão da estrutura e funcionamento do projeto.

## 1. Criação da Branch `ETAPA-4`

Foi criada uma nova branch com o nome `ETAPA-4` para realizar as modificações e gerar a documentação do código. Todas as alterações e a documentação gerada foram feitas nesta branch.

## 2. Documentação com Javadoc

A documentação foi gerada utilizando a ferramenta **Javadoc**, que criou uma versão HTML detalhada do código-fonte. Para isso, todos os métodos, classes e variáveis foram documentados conforme os padrões do Javadoc.

- O Javadoc foi gerado para as classes e métodos do código presente no repositório.
- A documentação gerada foi armazenada na pasta `doc/`.

## 3. Comentários no Código

Além do Javadoc, o código também recebeu os seguintes tipos de comentários:

- **Comentários de uma linha (`//`)**: Utilizados para adicionar explicações curtas sobre a lógica de partes específicas do código.
- **Comentários de múltiplas linhas (`/* <comentário> */`)**: Utilizados para descrever de forma mais detalhada o funcionamento de blocos de código.
- **Comentários de documentação Javadoc (`/** <comentário> */`)**: Utilizados para descrever classes, métodos e variáveis, explicando seu propósito e funcionamento.

## 4. Geração do Javadoc

A documentação foi gerada utilizando o comando `javadoc`, que criou os arquivos HTML necessários. O comando utilizado foi:

```bash
javadoc -d doc/ src/login/*.java
