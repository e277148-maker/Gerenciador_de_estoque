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

# Alterações em relação ao projeto inicial

Durante o desenvolvimento, algumas decisões de projeto foram revistas em
relação ao diagrama UML originalmente proposto.

As principais alterações foram:

-   Implementação de uma interface gráfica utilizando JavaFX,
    funcionalidade que não estava prevista no diagrama inicial.
-   Não utilização das classes `Administrador` e `Gerente`. Em vez
    disso, foi adotada uma única classe `Usuarios`, contendo os
    atributos `nome`, `login`, `senha` e `tipo`, simplificando a
    modelagem sem perda de funcionalidade.
-   Não utilização do padrão Factory Method para criação de usuários. 
    utilização de uma unica classe `Usuarios` tornou desnecessária o 
    uso do Factory Method, uma vez que a criação de novos usuarios foi 
    simplificada. 
-   Implementação da funcionalidade de cadastro de novos produtos,
    recurso que não fazia parte da proposta original, mas que foi
    incorporado para tornar o sistema mais completo e facilitar o
    gerenciamento do estoque.