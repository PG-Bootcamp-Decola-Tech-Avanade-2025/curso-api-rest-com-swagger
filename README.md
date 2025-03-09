# Projeto de estudo, seguindo o conteúdo apresentado no curso 'Criando uma API REST Documentada com Spring Web e Swagger'
O repositório contém, além das anotações nesse documento, um projeto Spring Boot desenvolvido seguindo o conteúdo apresentado na aula.
Caso haja divergência deixo claro, em comentários no código, o porquê de ter divergido da implementação demonstrada no curso.

Nesse caso, em específico, as aulas cobrem conteúdo já estudado durante outras aulas. Minhas anotações serão apenas sobre os conteúdos novos.

## Setup
### Estrutura do projeto + dependências iniciais
O projeto foi estruturado da com ajuda da ferramenta [Spring Initializr](start.spring.io), incluindo algumas dependências que—acredito—serão necessárias no curso.

## Anotações
Divergindo um pouco do conteúdo da aula, decidi por utilizar uma dependência alternativa para inserir o Swagger na aplicação.
Por simplicidade de implementação e pra testar algo diferente, a dependência que optei por utilizar foi a `springdoc-openapi`,
acessível com a seguinte declaração de dependência no arquivo pom.xml:
    ```
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        <version>2.8.5</version>
    </dependency>
    ```
Adicionada a dependência, não é necessária nenhuma configuração adicional; São disponibilizados os endpoints
`/v3/api-docs`, que dá acesso ao schema json gerado descrevendo os endpoints, e `/swagger-ui/index.html`,
pelo qual fica acessível a UI do Swagger.
É possível modificar os endpoints disponibilizados adicionando algumas configurações ao arquivo application.properties:
```
springdoc.swagger-ui.path=<path-swagger>
springdoc.api-docs.path=<path-json>
```

## Referências
[Baeldung - Documenting a Spring REST API Using OpenAPI 3.0](https://www.baeldung.com/spring-rest-openapi-documentation)
