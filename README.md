# Gerenciador de Estoque

Sistema de gerenciamento de estoque desenvolvido como projeto final da disciplina **MC322AB – Programação Orientada a Objetos**, do Instituto de Computação da Universidade Estadual de Campinas (UNICAMP). O projeto foi desenvolvido com foco na aplicação de conceitos de orientação a objetos, interface gráfica e persistência de dados, conforme a proposta apresentada pelo grupo. fileciteturn1file1 fileciteturn1file18

## Autores

- Enzo Villani Tonuz
- Leonardo M. Amêndola

## Objetivo

O sistema tem como objetivo facilitar o gerenciamento de estoques de estabelecimentos comerciais, permitindo o cadastro de produtos e usuários, o controle de entradas e saídas de mercadorias, o armazenamento do histórico de movimentações e a geração de relatórios.

A proposta foi desenvolvida pensando em uma solução simples, intuitiva e reutilizável para pequenos e médios estabelecimentos. fileciteturn1file1

---

# Funcionalidades

O sistema implementa as seguintes funcionalidades:

- Login de usuários
- Cadastro de usuários
- Controle de permissões por tipo de usuário
- Cadastro de novos produtos
- Entrada de produtos no estoque
- Saída de produtos do estoque
- Consulta de produtos por ID
- Consulta do histórico de movimentações
- Geração automática de relatório em arquivo `.txt`
- Persistência automática dos dados em arquivos JSON

---

# Tecnologias utilizadas

- Java 21
- JavaFX
- Gradle
- Jackson Databind
- FXML (Scene Builder)

---

# Organização do projeto

``` id="ly0790"
app/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │
│   │   ├── controllers/
│   │   ├── comandos/
│   │   ├── estoque/
│   │   ├── produto/
│   │   ├── historico/
│   │   ├── usuarios/
│   │   ├── login/
│   │   ├── relatorios/
│   │   ├── exceptions/
│   │   └── app/
│   │
│   └── resources/
│       └── fxml/
│
dados/
├── estoque.json
├── historico.json
├── usuarios.json
└── configuracao.json

relatorios/
```

---

# Persistência dos dados

Os dados são armazenados automaticamente em arquivos JSON utilizando a biblioteca Jackson.

Arquivos utilizados:

- `estoque.json`
- `usuarios.json`
- `historico.json`
- `configuracao.json` (armazenamento do próximo ID disponível)

Dessa forma, todas as alterações permanecem salvas após o encerramento da aplicação.

---

# Interface

A aplicação utiliza JavaFX para fornecer uma interface gráfica composta pelas seguintes telas:

- Login
- Menu principal
- Entrada de produtos
- Saída de produtos
- Consulta de estoque
- Consulta de histórico
- Cadastro de usuários
- Cadastro de produtos

---

# Funcionamento

## Login

O acesso ao sistema é realizado através de login e senha.

Após a autenticação, o usuário é encaminhado ao menu principal.

---

## Controle de estoque

É possível:

- cadastrar produtos;
- registrar entradas;
- registrar saídas;
- consultar quantidade disponível;
- visualizar produtos cadastrados.

Cada produto possui:

- ID único;
- nome;
- quantidade;
- quantidade mínima.

O ID é gerado automaticamente pelo sistema e seu valor é persistido para evitar repetições após reinicializações da aplicação.

---

## Histórico

Toda movimentação realizada gera automaticamente um registro contendo:

- tipo da movimentação;
- produto;
- quantidade;
- usuário responsável;
- data da operação.

O histórico pode ser consultado diretamente pela interface.

---

## Relatórios

O sistema gera automaticamente um relatório em formato `.txt`.

O relatório contém informações como:

- quantidade de produtos cadastrados;
- quantidade total de itens em estoque;
- produtos abaixo da quantidade mínima;
- número total de movimentações;
- situação completa do estoque.

Caso já exista um relatório com o mesmo nome, um novo arquivo é criado automaticamente sem sobrescrever o anterior.

---

# Padrões de projeto utilizados

Durante o desenvolvimento foram utilizados conceitos e padrões de projeto vistos na disciplina, incluindo:

- MVC (Model–View–Controller)
- Command Pattern
- Factory (para criação de usuários)
- Separação entre interface gráfica e lógica de negócio
- Persistência utilizando serialização JSON

---

# Como executar

Clone o repositório:

```bash id="z6dcho"
git clone <url-do-repositorio>
```

Entre na pasta:

```bash id="qdbqrk"
cd gerenciador_de_estoque
```

Execute:

```bash id="35v8qe"
./gradlew run
```

---

# Dependências

As principais dependências utilizadas são:

```gradle id="gube1s"
implementation 'com.fasterxml.jackson.core:jackson-databind:2.20.0'
```

e o plugin JavaFX:

```gradle id="laho37"
id 'org.openjfx.javafxplugin'
```

---

# Objetivos de Orientação a Objetos

O projeto foi desenvolvido visando a aplicação dos conceitos estudados na disciplina, incluindo:

- encapsulamento;
- abstração;
- composição;
- reutilização de código;
- modularização;
- tratamento de exceções;
- persistência de dados;
- separação de responsabilidades;
- interface gráfica integrada à lógica da aplicação.

---

# Considerações finais

Este projeto representa a implementação de um sistema completo de gerenciamento de estoque com interface gráfica, persistência de dados e arquitetura baseada em orientação a objetos. O desenvolvimento buscou seguir os requisitos definidos na proposta do projeto e aplicar os principais conceitos abordados na disciplina MC322AB. fileciteturn1file1 fileciteturn1file18
