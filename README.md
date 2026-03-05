# 📚 LiteAlura - Catálogo de Livros e Autores

O **LiteAlura** é um desafio (challenge) do programa **Oracle Next Education (ONE)**. O objetivo é desenvolver um catálogo de livros que interaja com uma API externa e armazene os dados em um banco de dados relacional para consultas futuras.

---

## 🚀 Sobre o Projeto (About the Project)
Esta aplicação permite que o usuário busque livros diretamente da API [Gutendex](https://gutendex.com/), processe os dados em formato JSON e os salve em um banco de dados **PostgreSQL**. A interação acontece de forma simples através de um menu no terminal (terminal menu).

---

## ✨ Funcionalidades (Features)
O sistema oferece as seguintes operações (operations):
*   🔍 **Buscar livros por título**: Realiza uma requisição HTTP (HTTP request) e salva o livro e seu autor no banco.
*   📖 **Listar livros registrados**: Recupera todos os livros salvos localmente.
*   👨‍🎨 **Listar autores registrados**: Mostra todos os autores que possuem livros no seu catálogo.
*   🕰️ **Filtrar autores vivos**: Busca autores que estavam vivos em um ano específico informado pelo usuário.
*   🌍 **Filtrar por idioma**: Lista os livros de acordo com a língua (ex: `en` para inglês, `pt` para português).

---

## 🛠️ Tecnologias Utilizadas (Tech Stack)
Para construir este projeto, utilizei as seguintes ferramentas (tools):
*   **Java 17**: Linguagem base.
*   **Spring Boot 3**: Framework para agilizar o desenvolvimento.
*   **Spring Data JPA**: Para gerenciar a persistência de dados (database persistence).
*   **PostgreSQL**: Banco de dados relacional.
*   **Jackson**: Para converter os dados da API para objetos Java (DTOs).
*   **HttpClient**: Para realizar as chamadas à API Gutendex.

---

## 📂 Estrutura do Código (Code Structure)
*   `model/`: Contém as entidades (entities) `Book` e `Author`.
*   `dto/`: Classes de record para mapear o JSON da API.
*   `repository/`: Interfaces que estendem `JpaRepository` para o banco de dados.
*   `service/`: Lógica de conversão de dados.
*   `main/`: Contém o `Menu` e a classe principal de execução.

---

## ⚙️ Como Configurar (How to Setup)
1.  **Banco de Dados**: Crie um banco chamado `litealura` no seu PostgreSQL.
2.  **Configuração**: No arquivo `src/main/resources/application.properties`, ajuste as credenciais (credentials):
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/litealura
    spring.datasource.username=seu_usuario
    spring.datasource.password=sua_senha
    ```
3.  **Execução**: Use o Maven para rodar o projeto:
    ```bash
    mvn spring-boot:run
    ```

---

## 📝 Licença (License)
Este projeto está sob a licença MIT.

---
Desenvolvido por **Vinicius Feitosa de Souza Filho** 🚀
