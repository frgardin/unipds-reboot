# Quarkus

## Como o quarkus surgiu

- 1996 a 2013: Java sai de um laboratorio da sun microsystems e chega ao status de linguagem mais utilizada no mundo
- 2013: Docker é lançado e estabelece um padrao ao uso de containers (que já existem há muito tempo)
- 2014: Lançamento do Java 8, ainda sem suporte a containers (que só começaria a vir a partir da build 121)
- 2015 a 2018: inumeras features voltadas a containers sao introduzidas a plataforma java, culminando na versao 11, que se tornou a versao minima recomendada para uso de java em containers
- 2016: lancamento do eclipse microprofile. a primeira especificacao voltada ao uso de java em microservices e sem uso de application servers
- 2019: primeira demonstracao publica do quarkus, com a promessa supersonic subatomic java


## O que quarkus?

- a kubernetes native java stack tailored for OpenJDK HotSpot and GraalVM, crafted from the best breed java libraries and standards
- ou seja, o quarkus em si mesmo eh uma stack completa que permite o desenvolvimento de aplicacoes prontas para rodar em kubernetes (de containers first a kubernetes native), com 100% de compatilidade tanto com o open jdk quanto com compilacao nativa (via graalvm)
- possibilita o desenvolvimento de todo tipo de aplicacao: monólitos, microservices, serverless, command-line tools, event driven, web app, etc
- traz em sua plataforma toda integracao com os maiores projetos open source do mercado como: kubernetes, camel, hibernate, langchain4j, openshift, kafka... alem de integracao com os principais provedores de servicos, como: AWS, Google e Azure

## Containers First

- tudo no quarkus foi pensado visando o uso em ambientes de containers
    - otimizacao de espaco em disco, visando imagens de containers menores
    - otimizacao de tempo de startup, visando escalabilidade instantanea
    - otimizacao de memoria e CPU, visando maior desidade de deployment

## Kubernetes Native

- ja que tudo eh feito para rodar em containers, entao faz sentido fazer tudo rodar em kubernetes
    - metricas
    - health check
    - debugging
    - tracing
    - config maps
    - secrets
    - yaml

## experiencia de usuario

- usuario = desenvolvedor
- um dos poucos frameworks para trazer uma experiencia de uso realmente diferenciada
    - live reload em fracoes de segundo
    - dev services (banco de dados, kafka, servidores de email... tudo em seu ambiente local com setup automatico via TestContainers)
    - compilacao native (out of the box)

