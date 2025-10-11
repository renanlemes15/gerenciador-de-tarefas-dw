## Integrantes
* Renan Manoel Lemes
  
# API de Gerenciador de Tarefas (To-Do List)

## Descrição

API RESTful desenvolvida como projeto para a disciplina de Desenvolvimento de Desenvolvimento Web da UEPG. O objetivo é aplicar os conceitos do ecossistema Spring (Spring Boot, Spring Data JPA) para construir um gerenciador de tarefas completo, seguindo as melhores práticas de desenvolvimento de APIs.

## Funcionalidades

* Criar, Listar, Atualizar e Deletar tarefas.
* Marcar uma tarefa como concluída.
* Listar apenas as tarefas pendentes (`concluida = false`).
* Filtrar tarefas por descrição.
* Validação de dados na criação e atualização de tarefas (Ex: descrição não pode ser vazia, prioridade deve estar entre 1 e 5).

## Tecnologias Utilizadas

* **Backend:** Java 17, Spring Boot 3, Spring Data JPA (Hibernate)
* **Banco de Dados:** PostgreSQL
* **Build:** Maven
* **Validação:** Spring Boot Starter Validation (Hibernate Validator)
