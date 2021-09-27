## **Sistema de Controle de Acervo de Obras** 

 

**Responsáveis** 

Esta seção do documento apresenta informações sobre o prestador de serviços Grupo 01 e o cliente solicitante do projeto Accenture - Academia JAVA. 

1. **Prestador do Serviço**: Grupo 01. 

Projeto e Codificação. Grupo 01. E-mail: grupo01@academiajava.com 

2. **Cliente**: Accenture - Academia JAVA. 

Sistema de Controle de Acervo de Obras. E-mail: clienteaccenture@academiajavaaccenture.com 

 

### **Documento de Visão do Sistema** 

1. **Objetivo** 

O propósito deste documento é coletar, analisar e definir as necessidades e características do Sistema de Controle de Acervo de Obras, focando nas potencialidades requeridas pelos desenvolvedores além de usuários-alvo e como estes requisitos foram abordados no sistema. A visão do sistema documenta o ambiente geral de processos desenvolvidos para o sistema, fornecendo a todos os envolvidos uma descrição compreensível deste e suas macro funcionalidades. 

 

2. **Descrição do Produto** 

O Sistema de Controle de Acervo de Obras é um projeto direcionado ao controle dos dados de Obras e Autores, que irá fazer a criação, leitura de dados, atualização e deleção desses exemplares e seus respectivos autores. Tendo em vista essas informações, podemos identificar que o sistema é um CRUD (Create - Criação, Read - Leitura, Update - Atualização, Delete - Deleção). É fornecida a possibilidade de adicionar atributos nas Obras, tais como: Id da Obra (esse será adicionado automaticamente pelo sistema), Nome da Obra, Descrição, Data de Publicação e Autores, além disso também existe a possibilidade de adição dos dados de Autores, tais como: Nome do Autor, País, Ano de Nascimento, CPF (sendo este opcional). 

Autor e Obra são tratados no sistema como Entidades através da Anotação do Spring Boot @Entity. Tendo em vista, essas informações podemos visualizar três Regras de Negócio do sistema: 

1) Cada obra deverá ter 1(um) ou n autor(es). 

2) A partir de uma obra deverá ser possível acessar o(s) autor(es). 

3) A partir de um autor deverá ser possível acessar a(s) obra(s). 

Onde podemos observar que caso exista uma obra, é necessário e indispensável existir também vinculado a ela um autor como descrito na Regra de Negócio 1(um). Nas demais regras, é possível visualizar a existência de relacionamentos, onde tanto a Regra 2(dois) quanto a Regra 3(três) é do relacionamento @OneToMany, ou seja, uma entidade pode se relacionar com vários itens de outra entidade. 

 

3. **Requisitos de Negócio** 

   3.1 **Abrangência Complementar a Descrição** 

O Sistema de Controle de Acervo de Obras foi concebido para o uso da Accenture - Academia JAVA da forma que melhor lhe servir, tendo em vista que será utilizado de forma didática e prática na conclusão do curso. Para total funcionamento desse sistema, indicamos que exista acesso as ferramentas como: Spring Boot e suas Dependências necessárias, JUnit, Plugin Coverage, Postman, Banco de Dados H2, além de um Browser para existir a possibilidade de acesso ao H2 através do localhost:8080/h2-console. 

​	3.1.1 **Operações** 

As Operações a serem realizadas são referentes ao CRUD, onde as ações que iremos utilizar, nome dos métodos e suas respectivas Annotation(s) são: 

- POST – inserirObra() - @PostMapping 
- PUT – alterarObra() - @PutMapping 
- GET – consultarObra() - @GetMapping 
- DELETE – excluirObra() - @DeleteMapping 

Existindo Request e Response para cada uma delas, onde o conteúdo destes está no documento de requisitos técnicos para a Construção do Case, podendo ser solicitado ao Grupo 01 a qualquer momento. 

​	3.2 **Valor Provido ao Cliente** 

Além de realizar o controle de dados de Obras e Autores, esse sistema visa facilitar a inserção de dados, a visualização, a atualização e a possibilidade de deleção destes. Ademais, com todos esses parâmetros disponíveis os dados tornam-se informações, que podem ser utilizadas em outras aplicações e softwares. 

 

4. **Escopo e Limitações** 

   4.1 **Escopo do Release** 

O objetivo inicial é a simplicidade que trará ações intuitivas do usuário perante ao cenário do sistema, como também a boa funcionalidade do sistema para facilitar as ações referente ao CRUD. 

​	4.2 **Limitações e Exclusões** 

Não poderá existir na entidade “Obras” algum exemplar que não contenha Autor, mas na possibilidade de não existir informações sobre o autor, o sistema deverá o declarar como “DESCONHECIDO”. Além de não ser permitido no sistema a falta de acesso de Obras para Autores, como também de Autores para Obras. 

 

5. **Contexto do Negócio - Prioridades do Projeto** 

A maior prioridade do projeto é levar satisfação e ótima funcionalidade ao sistema que o cliente Accenture - Academia JAVA nos solicitou. Atendendo suas expectativas e frequentemente utilizando de seus feedbacks para a construção da aplicação, encaixando o produto nas especificações necessárias. Sua maior restrição é fazer algo que o cliente não tenha pedido, mudar o sentido do projeto/sistema sem a autorização do cliente é a maior restrição pré-determinada nesse documento. 

 

6. **Fatores de Sucesso do Produto** 

O sucesso será determinado através do funcionamento do Sistema de Controle de Acervo de Obras correspondente aos requisitos solicitados. Entre eles os procedimentos esperados referente ao CRUD, como também a boa compreensão de como o sistema funciona através do intuitivo do usuário. 



# Casos de Teste

 ![mapaMetal](https://user-images.githubusercontent.com/83321496/134978873-42f49bfe-4bf6-4cca-a9c8-9dc4290b899d.png)

**Documentação Casos de Teste Controle De Obras** 

**Regra de Negócio:** Cada obra deverá ter 1 (um) ou n autor(es). 

 

**CT 005 – Verificação de Autor** **(Obra Existente)** 

**Objetivo do Teste:** Verificar se ao fazer a listagem das Obras, o autor referente a obra também é listado. 

**Pré-condições:** Fazer a listagem da obra através do GET. 

**Ações do Passo:** 

1. Acessar Postman> adicionar a opção GET no select > adicionar corretamente a URL > clicar em Send. 

1. Verifique se foram retornados os dados requeridos com sucesso e também os dados do autor.  

**Resultados Esperados:** 

1. Sistema exibe os dados requeridos, após o click do botão Send. 

1. O Response é o conjunto de dados requeridos de Obras, existindo também os dados do Autor. 

 

**Regras de Negócio:** A partir de uma obra deverá ser possível acessar o(s) autor(es). 

 

**CT 010 – Acessar Autores** **(Obra Existente)** 

**Objetivo do Teste:** Verificar se ao realizar listagem de uma Obra no Sistema, também é possível visualizar o(s) autor(es). 

**Pré-condições:** Estar na URL correta para verificação da listagem de uma Obra, além dos dados de Autor(es) vinculados a ela. 

**Ações do Passo:** 

1. Acessar Postman> adicionar a opção GET no select > adicionar corretamente a URL > clicar em Send. 

1. Verifique se além da obra, também foram retornados os dados dos autores.  

**Resultados Esperados:** 

1. Sistema exibe os dados requeridos, após o click do botão Send. 

1. O Response é o conjunto de dados requeridos da Obra e também do(s) Autor(es) vinculadas a ela. 

 

 

**Regras de Negócio:** A partir de um autor deverá ser possível acessar a(s) obra(s). 

 

**CT 019 – Acessar Obras** **(Obra Existente)** 

**Objetivo do Teste:** Verificar se ao realizar listagem de um Autor no Sistema, também é possível visualizar a(s) obra(s). 

**Pré-condições:** Estar na URL correta para verificação da listagem de um Autor, além dos dados de Obra(s) vinculados a ele. 

**Ações do Passo:** 

1. Acessar Postman> adicionar a opção GET no select > adicionar corretamente a URL > clicar em Send. 

1. Verifique se além das obras, também foram retornados os dados dos autores.  

**Resultados Esperados:** 

1. Sistema exibe os dados requeridos, após o click do botão Send. 

1. O Response é o conjunto de dados requeridos do Autor e também da(s) Obra(s) vinculadas a ele. 
