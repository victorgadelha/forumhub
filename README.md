# ForumHub

ForumHub é uma aplicação web para gerenciamento de um fórum, construída para o **One - Oracle Next Education** em parceria com a **Alura**. Foi desenvolvido com Spring Boot, Spring Security, JWT para autenticação, e um banco de dados MySQL. A aplicação permite autenticação de usuários, criação, leitura, atualização e deleção (CRUD) de tópicos de discussão, e possui um sistema de permissões e segurança robusto.

### Pré-requisitos

- [JDK 21](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)
- [Maven](https://maven.apache.org/install.html)
- [Docker](https://www.docker.com/get-started) (para rodar o banco de dados MySQL)
  
## Configuração

### Configuração de Segurança

A aplicação utiliza Spring Security com JWT para autenticação e autorização. A configuração de segurança está localizada em `SegurancaConfig` e `SegurancaFiltro`.

## Desenvolvido por
Este projeto foi desenvolvido por **Victor Gadelha**.
