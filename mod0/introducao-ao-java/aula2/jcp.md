# Java Community Process (JCP)

## O que é o JCP?

O **Java Community Process (JCP)** é o processo formal para desenvolver especificações técnicas para a plataforma Java. Ele permite que a comunidade participe ativamente na evolução do Java.

```
JCP = Processo colaborativo para definir o futuro do Java
```

## História do JCP

O JCP foi criado em **1998** pela Sun Microsystems (posteriormente adquirida pela Oracle) para permitir que empresas e desenvolvedores contribuíssem para a evolução do Java.

### Linha do Tempo
```
1998 - Criação do JCP pela Sun Microsystems
    ↓
2006 - Sun libera o código do Java (OpenJDK)
    ↓
2010 - Oracle adquire a Sun Microsystems
    ↓
2017 - Oracle transfere o Java EE para a Eclipse Foundation
    ↓
Hoje - JCP continua evoluindo o Java SE
```

## Como o JCP Funciona?

### Membros do JCP

Qualquer pessoa ou organização pode se tornar membro do JCP:

| Tipo de Membro | Quem pode participar | Custo |
|----------------|---------------------|-------|
| **Individual** | Qualquer pessoa | Gratuito |
| **Corporativo** | Empresas e organizações | Taxa anual |
| **Sem fins lucrativo** | Universidades, ONGs | Gratuito |

### Papéis Importantes

```
JCP Members
├── Executive Committee (EC)
│   ├── Guia a direção do JCP
│   ├── Aprova ou rejeita JSRs
│   └── Vota em novas especificações
├── Spec Lead (Líder da Especificação)
│   ├── Responsável pela especificação
│   ├── Coordena o Expert Group
│   └── Entrega a especificação final
├── Expert Group
│   ├── Especialistas técnicos
│   ├── Desenvolvem a especificação
│   └── Fornecem feedback técnico
└── Public (Comunidade em geral)
    ├── Comenta nas revisões públicas
    ├── Reporta bugs
    └── Suggest melhorias
```

## Java Specification Request (JSR)

Um **JSR** é um documento formal que propõe uma nova especificação ou alteração em uma existente.

### Estrutura de um JSR

```
JSR (Java Specification Request)
├── Título
├── Sumário Executivo
├── Justificativa
│   └── Por que esta especificação é necessária?
├── Tecnologias Relacionadas
├── Pacotes Afetados
├── Expert Group Proposto
└── Cronograma de Entrega
```

### Exemplos de JSRs Importantes

| JSR | Nome | Versão do Java | Descrição |
|-----|------|----------------|-----------|
| **JSR 14** | Generics | Java 5 | Adicionou tipos genéricos |
| **JSR 201** | Language Features | Java 5 | Enums, autoboxing, foreach |
| **JSR 317** | JPA 2.0 | Java EE 6 | API de persistência |
| **JSR 335** | Lambda Expressions | Java 8 | Expressões lambda |
| **JSR 376** | Module System | Java 9 | Sistema de módulos |
| **JSR 380** | Bean Validation 2.0 | Java EE 8 | Validação de beans |
| **JSR 395** | Records | Java 16 | Classes de dados imutáveis |
| **JSR 394** | Pattern Matching | Java 17 | Matching de padrões |

## Processo de um JSR

### Etapas do Processo

```
1. PROPOSTA
    ↓
    JSR é submetido ao JCP
    ↓
2. APROVAÇÃO INICIAL
    ↓
    Executive Committee vota
    ↓
    Se aprovado, cria-se um Expert Group
    ↓
3. DESENVOLVIMENTO
    ↓
    Expert Group trabalha na especificação
    ↓
    Rascunhos são criados (Drafts)
    ↓
4. REVISÃO PÚBLICA
    ↓
    Draft é publicado para comentários
    ↓
    Comunidade pode dar feedback
    ↓
5. TESTES DE COMPATIBILIDADE
    ↓
    CTS (Compatibility Test Suite) é desenvolvido
    ↓
    Implementações devem passar nos testes
    ↓
6. APROVAÇÃO FINAL
    ↓
    Executive Committee vota novamente
    ↓
    Se aprovado, especificação é finalizada
    ↓
7. MANUTENÇÃO
    ↓
    Updates e correções são feitos
```

### Duração Típica

| Fase | Duração Estimada |
|------|------------------|
| Proposta | 1-2 meses |
| Desenvolvimento | 6-18 meses |
| Revisão Pública | 2-4 meses |
| Testes | 3-6 meses |
| Aprovação Final | 1-2 meses |
| **Total** | **12-30 meses** |

## JEP (JDK Enhancement Proposal)

Além dos JSRs, o Java também usa **JEPs** para evoluir:

### Diferença: JSR vs JEP

| Aspecto | JSR | JEP |
|---------|-----|-----|
| **Escopo** | Plataforma Java | JDK/OpenJDK |
| **Processo** | JCP formal | Processo mais ágil |
| **Resultado** | Especificação oficial | Feature no JDK |
| **Exemplo** | Lambda Expressions | Project Valhalla |

### Exemplos de JEPs

```
JEP 328: Flight Recorder
    ↓
Ferramenta de diagnóstico para Java

JEP 377: ZGC (Z Garbage Collector)
    ↓
GC de baixa latência

JEP 395: Records
    ↓
Classes de dados imutáveis

JEP 409: Sealed Classes
    ↓
Restringe hierarquia de classes
```

## Participação Comunitária

### Como Participar?

```
Participação no JCP
├── 1. Tornar-se Membro
│   ├── Individual (gratuito)
│   └── Corporativo (taxa)
├── 2. Participar de Expert Groups
│   ├── Candidatar-se como especialista
│   └── Contribuir tecnicamente
├── 3. Comentar em Revisões Públicas
│   ├── Ler drafts publicados
│   └── Enviar feedback
├── 4. Implementar Especificações
│   ├── Criar implementações
│   └── Reportar problemas
└── 5. Contribuir com Testes
    ├── Criar testes de compatibilidade
    └── Reportar bugs
```

### Benefícios de Participar

✅ **Acesso antecipado** a novas features
✅ **Influência** na direção do Java
✅ **Networking** com especialistas
✅ **Aprendizado** profundo do Java
✅ **Reconhecimento** na comunidade

## Casos de Estudo

### Case Study 1: Lambda Expressions (JSR 335)

```
Problema:
    Código verboso para operações com collections

Processo:
    JSR 335 proposto em 2009
    Expert Group formado com representantes de:
    - Oracle
    - Google
    - IBM
    - Red Hat
    - Comunidade

Resultado (Java 8, 2014):
    List<String> names = list.stream()
        .filter(s -> s.length() > 3)
        .map(String::toUpperCase)
        .collect(Collectors.toList());
```

### Case Study 2: Module System (JSR 376)

```
Problema:
    "JAR Hell" - dependências conflitantes
    Classpath complexo e difícil de gerenciar

Processo:
    JSR 376 proposto em 2014
    Projeto Jigsaw (implementação)
    Diversos drafts e revisões públicas

Resultado (Java 9, 2017):
    module com.example {
        requires java.base;
        requires java.logging;
        exports com.example.api;
    }
```

## Estrutura Organizacional

### Executive Committee (EC)

O EC guia a direção do JCP:

```
Executive Committee
├── Oracle (Chair)
├── IBM
├── Red Hat
├── Google
├── Amazon
├── Microsoft
├── SAP
├── Intel
├── Representantes de membros individuais
└── Representantes de membros corporativos
```

### Responsabilidades do EC

1. **Aprovar JSRs** para desenvolvimento
2. **Revisar especificações** em revisão pública
3. **Votar em aprovação final** de especificações
4. **Guiar a direção** da plataforma Java
5. **Resolver disputas** entre membros

## Ferramentas e Recursos

### Portal do JCP

🔗 [https://jcp.org/](https://jcp.org/)

O portal oficial do JCP onde você pode:
- Ver JSRs ativos e finalizados
- Tornar-se memroe
- Participar de revisões públicas
- Acessar documentação

### Referências Importantes

| Recurso | URL |
|---------|-----|
| JCP Main Site | https://jcp.org/ |
| JSR List | https://jcp.org/en/jsr/all |
| OpenJDK | https://openjdk.org/ |
| JEP Index | https://openjdk.org/jeps/ |

## Resumo

O **Java Community Process** é fundamental para:

✅ **Garantir** que o Java evolua de forma controlada e colaborativa
✅ **Permitir** que a comunidade participe da direção do Java
✅ **Manter** compatibilidade e estabilidade entre versões
✅ **Inovar** de forma transparente e aberta
✅ **Construir** consenso entre diferentes stakeholders

O JCP é o que torna o Java verdadeiramente **comunitário** e **aberto**, garantindo que a plataforma evolua de acordo com as necessidades reais dos desenvolvedores e empresas.

---

**Referências:**
- [Java Community Process Official Site](https://jcp.org/)
- [JCP Process Document](https://jcp.org/en/procedures/overview)
- [Active JSRs](https://jcp.org/en/jsr/all)
- [OpenJDK JEPs](https://openjdk.org/jeps/)