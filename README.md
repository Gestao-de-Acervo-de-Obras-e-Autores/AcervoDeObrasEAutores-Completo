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
