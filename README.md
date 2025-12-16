# SGHSS (Back-end) — Sistema de Gestão Hospitalar e de Serviços de Saúde

Projeto acadêmico com foco em **Back-end**, desenvolvido como parte da disciplina de Projetos (UNINTER).
O SGHSS centraliza informações de pacientes e processos assistenciais, com **API REST**, **controle de acesso por perfis** e **armazenamento seguro de credenciais**.

---

## Visão geral

Este repositório contém o **back-end** do SGHSS, com endpoints REST e autenticação.
A validação das funcionalidades foi feita consumindo a API via **Postman/cliente HTTP** (não há front-end como escopo principal).

---

## Principais funcionalidades

- API REST com **CRUD de Pacientes**
- Autenticação com **Spring Security (HTTP Basic)**
- Autorização por **perfil de usuário** (roles)
- Senhas armazenadas com **hash BCrypt**
- Organização em **arquitetura em camadas** (controllers / services / data access)

---

## Tecnologias

- **Java 17**
- **Spring Boot**
- **Spring Security**
- **MySQL**
- **Maven**
- **Postman** (testes manuais)

---

## Arquitetura do projeto (camadas)

- **Controllers**: recebem requisições HTTP e expõem os endpoints
- **Services**: regras de negócio e validações
- **Repositórios / Data Access**: comunicação com o banco e operações CRUD

---

## Modelo de dados (resumo)

O modelo relacional inclui tabelas como: `USUARIO`, `PERFIL_ACESSO`, `PACIENTE`, `PROFISSIONAL_SAUDE`, `CONSULTA`, `EXAME`, `PROCEDIMENTO`, `PRONTUARIO`, `PRESCRICAO`, `INTERNACAO` e `TRIAGEM`.

> Observação: embora o modelo contemple várias entidades do domínio hospitalar, os endpoints principais documentados neste repositório estão concentrados em **Pacientes** (núcleo do MVP do back-end).

---

## Como executar localmente

### Pré-requisitos
- Java 17 instalado
- MySQL disponível localmente
- Maven (ou Maven Wrapper `./mvnw`)

### Configuração do banco
1. Crie um banco no MySQL (ex.: `sghss`).
2. Ajuste o `application.properties`/`application.yml` com:
   - URL do datasource
   - usuário e senha do MySQL

### Subir a aplicação
```bash
# Linux/Mac
./mvnw spring-boot:run

# Windows
mvnw.cmd spring-boot:run
