## Autor
    Krossby Krossft

# Sistema de Agendamento de Visitas ao Condomínio

Sistema para gerenciamento de agendamento de visitas em condomínios, desenvolvido como parte da disciplina de
Arquiteturas Avançadas de Software com Microsserviços e Spring Framework.

## Tecnologias Utilizadas

- Java 21
- Spring Boot 3.5.5

## Projetos Relacionados

Este projeto integra-se com o [Sistema de Gestão de Portaria](https://github.com/krosscaal/infnet-sgp) para fornecer uma
solução completa de controle de acesso.

## Objetivo

    Objetivo do sistema e facilitar ao morador do condomínio o agendamento de visitas, 
    para agilizar no momento do visitante chegar na portaria com o cadastro e evitar tempo gasto 
    com procedimento de registro de acessos ao condomínio.

    Para isso o morador devera informar ao sistema de agendamento os dados do visitante sendo estes 
    por questões de segurança obrigatórios:
    - nome (obrigatório)
    - Sobrenome (obrigatório)
    - CPF (obrigatório)
    - cep (obrigatório)
    - Data e Hora da visita

    O sistema possue a com Classe Agendamento com os atributos:
    - nome;
    - sobrenome;
    - cpf;
    - endereco;
    - unidadeDaVisita;
    - idMoradorSolicitante;
    - dataVisita;
    - observacao;

    Classe Endereco com os atributos:
    - cep;
    - logradouro;
    - numero;
    - complemento;
    - bairro;
    - localidade;
    - estado;
    - uf;


## Feature 1:

    github: https://github.com/krosscaal/infnet-agendamentoapi 

    Implementações no service de Agendamento para validações de:
    - validações de nome e sobrenome, verificando que sejam somente letras.
    - validação de CPF verificando que seja somente números com 11 digitos, e que o número informado
        é um número de CPF válido.

    Implementações no service de Endereco para validações de:
    - validação do cep verificando que seja somente números com 8 digitos.

    Implementação de uma classe de utilidades, que contem métodos staticos para ajudar nas 
        validações como:
    - validar letras.
    - validar números.
    - validar cpf.

    Cobertura de testes:
    - ciclo TDD red-green-refactor para os services de Agendamento e Endereco assim como para 
        a classe de utilidades. 
    - pode ser acompanhado a traves dos Pull Requests deste projeto.

## Feature 2:

    Como citado acima no Objetivo, este sistema tem como finalidade o registro de agendamentos que
    posteriormente seriam solicitados via API pela aplicaçao:   
  [Sistema de Gestão de Portaria](https://github.com/krosscaal/infnet-sgp)

    - Foram adicionadas propiedades ao pom para uso do FeignClient.
      foi definido no aplications.properties para uso do FeignClient. as respecitvas urls, assim como
      uso de banco em memoria.

    Um agendamento deve possuir nome, sobrenome, cpf, cep e data de visita, unidade da visita como 
    principais dados.
    
    O sistema irá validar nome, sobrenome, cpf e cep.
    O sistema fara consulta a traves do FeignClient para duas Api externas que
    fornecem o cep:
    - hhttps://opencep.com/
    - https://viacep.com.br/

    O sistema fara consulta em ambas Apis, caso alguma retorne um resultado de erro.

    tendo resposta da Api serão persistidos os dados no banco.

    - Foi implementado as camada de controller e repository para Agendamento.
    - Foi implementado um AbastractConverter para converter os objetoResponse da Api para Endereco.
    - Foi implementado no service de Agendamento o tratemento da persistencia e de busca de agendamentos
      por data que a primeira aplicação fara uso via API exposta na camanda de controller.
    - Foi implementado no service de Endereco a busca do cep via Api externa assim como a conversão do
      response da Api para Endereco.
    - Foi feitas alterações nos testes para que continuem funcionando.
    - Foi implementando um Loader que carrega de um arquivo de texo dados que seriam
      os agendamentos de visita que ao levantar sistema o AgendamentoLoader sera executado.

    - Foi implementada na aplicação
[Sistema de Gestão de Portaria](https://github.com/krosscaal/infnet-sgp)

      as alterações para integrar-se com este sistema, 
      assim como a implementação de um JOB que a cada 10 segundos
      faz a consulta via Api com esta aplicação sobre os agendamentos
      para o data programada no job 29-09-2025. somente para teste da
      comunicação entre as duas aplicações.

