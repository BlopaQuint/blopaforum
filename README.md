# 📝 BlopaForum API REST

![Java](https://img.shields.io/badge/Java-21-blue)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5.4-green)
![MySQL](https://img.shields.io/badge/MySQL-8-orange)

## 📌 Descrição

BlopaForum é uma **API REST** desenvolvida em **Java 21** com **Spring Boot**, voltada para o gerenciamento de um fórum online.  
Permite cadastro, listagem, atualização e exclusão de tópicos, além de autenticação de usuários com **JWT**.

Este projeto foi desenvolvido como parte da **minha especialização Back-End TECH FOUNDATION** do programa **ONE - Oracle Next Education**, uma iniciativa educacional **Oracle** em parceria com a **Alura**, que visa formar desenvolvedores completos e preparados para o mercado.

## ⚙️ Funcionalidades

- Cadastro e gerenciamento de tópicos
- Listagem paginada de tópicos
- Autenticação e autorização com JWT
- Validação de dados com Bean Validation
- Senhas de usuários criptografadas com **BCrypt**
- Tratamento de erros personalizado
- Documentação automática com Swagger / SpringDoc
- Persistência em banco MySQL com Spring Data JPA
- Controle de versões do banco com Flyway
- API pronta para consumo via **Insomnia**, **Postman** ou ferramentas similares

## 🧪 Tecnologias

- Java 21
- Spring Boot 3.5.4
- Spring Security
- Spring Data JPA
- Hibernate
- MySQL
- Flyway
- SpringDoc OpenAPI (Swagger)
- JWT
- Lombok

## 🗂 Estrutura de Pacotes

```
com.example.blopaforum
├── controller         # Endpoints REST
├── domain
│   ├── topico         # Entidades e DTOs de tópicos
│   └── usuario        # Entidades e serviços de usuários
├── repository         # Repositórios JPA
├── service            # Regras de negócio
├── infra
│   ├── exception      # Tratamento de erros
│   ├── security       # JWT, filtro de autenticação e config
│   └── springdoc      # Configuração Swagger/OpenAPI
└── BlopaforumApplication.java
```

## 👤 Autor

[Pablo Quintiliano](https://github.com/BlopaQuint)

## 🚀 Configuração e Execução

1. Clonar o repositório:
```bash
git clone https://github.com/BlopaQuint/blopaforum
```

2. Executar o projeto com Maven:
```bash
./mvnw spring-boot:run
```

3. Acessar a documentação Swagger:
```bash
http://localhost:8080/swagger-ui.html
```


## 📄 Licença

Este projeto está licenciado sob os termos da **MIT License**.