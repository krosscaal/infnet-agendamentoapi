# Sistema de Agendamento de Visitas ao Condomínio

Sistema para gerenciamento de agendamento de visitas em condomínios, desenvolvido como parte da disciplina de
Arquiteturas Avançadas de Software com Microsserviços e Spring Framework.

## Tecnologias Utilizadas

- Java 21
- Spring Boot 3.5.5
- Spring MVC
- Jakarta EE

## Projetos Relacionados

Este projeto integra-se com o [Sistema de Gestão de Portaria](https://github.com/krosscaal/infnet-sgp) para fornecer uma
solução completa de controle de acesso.

## Objetivo

    Objetivo deste sistema e facilitar ao morador do condomínio o agendamento de visitas, para ter agilidade no momento das visitas chegarem na portaria
    e evitar o tempo gasto com cadastro no procedimento normal de registro de acessos ao condomínio.

    Para isso o morador devera informar ao sistema de agendamento os dados do visitante sendo estes por questoes de segurança obrigatórios:
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
    - validação de CPF verificando que seja somente números com 11 digitos, e que o número informado é um número de CPF válido.

    Implementações no service de Endereco para validações de:
    - validação do cep verificando que seja somente números com 8 digitos.

    Implementação de uma classe de utilidades, que contem métodos staticos para ajudar nas validações como:
    validar letras.
    validar números.
    validar cpf.

    Cobertura de testes:
    - ciclo TDD red-green-refactor para os services de Agendamento e Endereco assim como para a classe de utilidades. 
    - pode ser acompanhado a traves dos Pull Requests deste projeto.

