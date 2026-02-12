# Desafio Técnico – StarkBank

Este projeto foi desenvolvido como solução para o **Desafio Técnico da StarkBank**.

O objetivo é implementar uma aplicação backend robusta, organizada e escalável, seguindo boas práticas de arquitetura e desenvolvimento em Java.

---

## Objetivo do Desafio

Construir uma aplicação backend capaz de:

* Processar requisições HTTP
* Aplicar regras de negócio
* Estruturar corretamente camadas de domínio
* Seguir princípios de Clean Architecture
* Garantir organização modular e separação de responsabilidades

---

## Arquitetura do Projeto

O projeto foi estruturado em múltiplos módulos Maven:

```
desafio-starkbank/
│
├── application/     # Camada de entrada (API REST)
├── domain/          # Regras de negócio e entidades
├── infrastructure/  # Implementações externas (persistência, integrações)
├── output/          # Artefato final empacotado
└── pom.xml          # POM pai
```

### Organização por Camadas

* **Domain**

    * Entidades
    * Regras de negócio
    * Interfaces (ports)

* **Application**

    * Controllers
    * DTOs
    * Casos de uso
    * Configurações da aplicação

* **Infrastructure**

    * Implementações de repositórios
    * Integrações externas
    * Configurações técnicas

* **Output**

    * Responsável por gerar o `.jar` final executável

---

## 🛠️ Tecnologias Utilizadas

* Java 21+
* Spring Boot 4.x
* Maven (multi-module)
* Docker (opcional)
* Railway (deploy)

---

##  Como Executar Localmente

### 1️⃣ Clonar o repositório

```bash
git clone https://github.com/seu-usuario/desafio-starkbank.git
cd desafio-starkbank
```

### 2️⃣ Build do projeto

Na raiz do projeto:

```bash
mvn clean install
```

## Executando com Maven

Alternativamente:

```bash
mvn spring-boot:run -pl application
```

---

## Executando com Docker (opcional)

### Build da imagem

```bash
docker build -t desafio-starkbank .
```

### Rodar container

```bash
docker run -p 8080:8080 desafio-starkbank
```

---

## Deploy no Railway

No Railway, o comando de start deve apontar corretamente para o jar gerado:

Exemplo:

```bash
java -jar application/target/*.jar
```

Ou:

```bash
java -jar output/target/*.jar
```

Certifique-se de que:

* O módulo correto está sendo buildado
* O `.jar` está sendo gerado
* O comando Start está configurado corretamente

---

## Boas Práticas Aplicadas

* Separação clara de responsabilidades
* Baixo acoplamento entre módulos
* Arquitetura orientada a domínio
* Modularização com Maven
* Código organizado para escalabilidade

---

## Considerações Finais

Este projeto foi estruturado com foco em:

* Clareza arquitetural
* Manutenibilidade
* Escalabilidade
* Organização profissional de código

