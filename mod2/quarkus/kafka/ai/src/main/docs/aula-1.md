# IA Corporativa com Java e Langchain4j

## Overview e Fundamentos

- Diferenciar IA preditiva e IA generativa
- Compreender a fundamento do curso: o desenvolvedor Java com integrador de IA, nao como cientista de dados
- Identificar os componentes do stack tecnologico:
  - quarkus
  - langchain4j
  - ollama
- visualizar a arquitetura inicial da implementacao de referencia do curso e seu plano de evolucao

## O mundo da IA: duas realidades distintas

- a inteligencia artificial no ambiente corporativo se manifesta em duas vertentes principais, com propositos e capacidades fundamentalmente diferentes

- IA preditiva:
  - tecnologia madura, baseada em modelos estatisticos e machine learning classico
  - objetivo: analisar dados historicos para prever resultados futuros ou classificar informacoes
  - saida: estruturada (um numero, uma categoria, uma probabilidade). Ex: score de credito, deteccao de fraude

- IA generativa:
  - tecnologia emergenete projetada para criar conteudo novo e original
  - base: utiliza large language models (LLMs) para gerar textos, imagens, musica, e codigo em resposta a um prompt
  - saida: nao estruturada e criativa. abre possibilidades para automacao de comunicacao e desenvolvimento de software

## O papel do desenvolvedor

- a transicao da IA preditiva para a generativa eleva o desenvolvedor de um mero consumidor de APIs para um arquiteto de sistemas cognitivos.

| Característica     | IA Preditiva                                              | IA Generativa                                                   |
|--------------------|-----------------------------------------------------------|-----------------------------------------------------------------|
| **Objetivo**       | Prever resultados futuros ou classificar informações      | Criar conteúdo novo e original a partir de um prompt            |
| **Base tecnológica**| Modelos estatísticos e machine learning clássico         | Large Language Models (LLMs)                                    |
| **Tipo de saída**  | Estruturada (número, categoria, probabilidade)            | Não estruturada e criativa (texto, imagem, código, música)      |
| **Maturidade**     | Tecnologia madura e consolidada                           | Tecnologia emergente em rápida evolução                         |
| **Exemplos de uso**| Score de crédito, detecção de fraude, recomendações       | Chatbots, geração de código, automação de comunicação           |
| **Entrada**        | Dados históricos estruturados                             | Linguagem natural (prompt)                                      |
| **Papel do Desenvolvedor** | Consumidor de Modelo: Integrar uma API que retorna uma predicao | Arquiteto Cognitivo: Orquestrar o fluxxo de informacao e o raciocinio do LLM. |

### IA Preditiva

O desenvolvedor invocava um endpoint e processava uma resposta estrutura, tratando o modelo como uma "caixa-preta".

### IA Generativa

O desafio é mais estratégico. O desenvolvedor precisa projetar todo o fluxo de "pensamento" da aplicaçao:
    - Determinar se e quais informacoes externas sao necessarias (ex: RAG)
    - Formatar essas informacoes em estruturas e prompts eficazes
    - Definir e disponibilizar ferramentas que serao integradas ao LLM
    - Validar e utilizar a resposta gerada

## Foco em integracao, nao em ciencia de dados

- A grande forca do java está em sua vasta integracao dentro do ambiente corporativo
- o real valor do desenvolvedor java na era da IA nao esta em treinar modelos, mas na integracao de LLMs pre treinados com os sistemas corporativos existentes (ERPs, CRMs, etc.)
- O ecossistema Java eh ideal para esta tarefa devido a:
  - escalabilidade e performance: frameworks como quarkus sao otimizados para nuvem, com baixo consumo de memoria e startup rapido
  - seguranca: modelo de seguranca maduro para manuseio de dados sensiveis
  - ecossistema maduro