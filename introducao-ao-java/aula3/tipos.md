# Tipos de Dados em Java

## Visão Geral

Java possui dois tipos principais de dados:

```
Tipos em Java
├── Tipos Primitivos (8 tipos)
│   ├── Inteiros: byte, short, int, long
│   ├── Ponto flutuante: float, double
│   ├── Lógico: boolean
│   └── Caractere: char
└── Tipos de Referência
    ├── Classes
    ├── Interfaces
    ├── Arrays
    └── Enums
```

## Tipos Primitivos

Os **tipos primitivos** são os tipos básicos do Java. Eles armazenam valores diretamente na memória.

### Tabela de Tipos Primitivos

| Tipo | Tamanho | Valor Mínimo | Valor Máximo | Valor Padrão | Exemplo |
|------|---------|--------------|--------------|--------------|---------|
| **byte** | 1 byte (8 bits) | -128 | 127 | 0 | `byte b = 100;` |
| **short** | 2 bytes (16 bits) | -32.768 | 32.767 | 0 | `short s = 1000;` |
| **int** | 4 bytes (32 bits) | -2.147.483.648 | 2.147.483.647 | 0 | `int i = 100000;` |
| **long** | 8 bytes (64 bits) | -9.223.372.036.854.775.808 | 9.223.372.036.854.775.807 | 0L | `long l = 100000000L;` |
| **float** | 4 bytes (32 bits) | ~±3.4 × 10³⁸ | ~±3.4 × 10³⁸ | 0.0f | `float f = 3.14f;` |
| **double** | 8 bytes (64 bits) | ~±1.7 × 10³⁰⁸ | ~±1.7 × 10³⁰⁸ | 0.0d | `double d = 3.14159;` |
| **boolean** | 1 bit* | - | - | false | `boolean b = true;` |
| **char** | 2 bytes (16 bits) | '\u0000' (0) | '\uffff' (65.535) | '\u0000' | `char c = 'A';` |

*\* O tamanho do boolean depende da implementação da JVM*

## Tipos Inteiros

### 1. byte (1 byte)

O menor tipo inteiro. Usado para economizar memória.

```java
public class ByteExample {
    public static void main(String[] args) {
        byte idade = 25;
        byte temperatura = -10;
        byte maximo = 127;
        byte minimo = -128;
        
        System.out.println("Idade: " + idade);           // 25
        System.out.println("Temperatura: " + temperatura); // -10
        System.out.println("Máximo: " + maximo);          // 127
        System.out.println("Mínimo: " + minimo);          // -128
        
        // byte overflow - cuidado!
        // byte overflow = 128; // Erro de compilação
    }
}
```

**Quando usar:**
- Leitura de dados binários
- Comunicação com hardware
- Quando precisar economizar memória

### 2. short (2 bytes)

Tipo inteiro de tamanho intermediário.

```java
public class ShortExample {
    public static void main(String[] args) {
        short populacao = 15000;
        short temperatura = -500;
        short maximo = 32767;
        
        System.out.println("População: " + populacao);      // 15000
        System.out.println("Temperatura: " + temperatura);  // -500
        System.out.println("Máximo: " + maximo);            // 32767
    }
}
```

### 3. int (4 bytes)

O tipo inteiro mais usado. Ideal para a maioria dos casos.

```java
public class IntExample {
    public static void main(String[] args) {
        int populacao = 214000000;
        int distancia = -1500;
        int maximo = Integer.MAX_VALUE;  // 2147483647
        int minimo = Integer.MIN_VALUE;  // -2147483648
        
        System.out.println("População do Brasil: " + populacao);
        System.out.println("Distância: " + distancia + " km");
        System.out.println("Valor máximo int: " + maximo);
        System.out.println("Valor mínimo int: " + minimo);
        
        // Operações com int
        int soma = 10 + 20;
        int produto = 5 * 3;
        int resto = 17 % 5;
        
        System.out.println("Soma: " + soma);        // 30
        System.out.println("Produto: " + produto);  // 15
        System.out.println("Resto: " + resto);      // 2
    }
}
```

### 4. long (8 bytes)

Para números inteiros muito grandes.

```java
public class LongExample {
    public static void main(String[] args) {
        long distanciaEmKm = 150000000L;  // 150 milhões de km
        long tempoEmMilissegundos = System.currentTimeMillis();
        long maximo = Long.MAX_VALUE;  // 9223372036854775807
        
        System.out.println("Distância: " + distanciaEmKm + " km");
        System.out.println("Tempo atual (ms): " + tempoEmMilissegundos);
        System.out.println("Valor máximo long: " + maximo);
        
        // Nota: Use o sufixo 'L' ou 'l' para literais long
        long correto = 1000000000L;
        // long errado = 1000000000;  // Pode causar overflow
    }
}
```

**Quando usar long:**
- Timestamps (milissegundos desde 1970)
- IDs de banco de dados grandes
- Cálculos astronômicos
- Quando int não é suficiente

## Tipos de Ponto Flutuante

### 5. float (4 bytes)

Precisão simples para números decimais.

```java
public class FloatExample {
    public static void main(String[] args) {
        float pi = 3.14159f;
        float temperatura = -273.15f;
        float maximo = Float.MAX_VALUE;  // ~3.4 × 10³⁸
        
        System.out.println("Pi: " + pi);
        System.out.println("Temperatura: " + temperatura + "°C");
        System.out.println("Valor máximo float: " + maximo);
        
        // Nota: Use o sufixo 'f' ou 'F' para literais float
        float correto = 3.14f;
        // float errado = 3.14;  // Erro - precisa do 'f'
        
        // Cuidado com precisão
        float soma = 0.1f + 0.2f;
        System.out.println("0.1 + 0.2 = " + soma);  // 0.30000001192092896
    }
}
```

**Quando usar float:**
- Quando precisar economizar memória
- Cálculos gráficos
- Quando precisão não é crítica

### 6. double (8 bytes)

Precisão dupla. Mais preciso e mais usado.

```java
public class DoubleExample {
    public static void main(String[] args) {
        double pi = 3.141592653589793;
        double velocidadeLuz = 299792458.0;  // m/s
        double maximo = Double.MAX_VALUE;     // ~1.7 × 10³⁰⁸
        
        System.out.println("Pi: " + pi);
        System.out.println("Velocidade da luz: " + velocidadeLuz + " m/s");
        System.out.println("Valor máximo double: " + maximo);
        
        // Operações matemáticas
        double raio = 5.0;
        double area = Math.PI * Math.pow(raio, 2);
        System.out.println("Área do círculo: " + area);
        
        // Atenção: double também tem problemas de precisão
        double soma = 0.1 + 0.2;
        System.out.println("0.1 + 0.2 = " + soma);  // 0.30000000000000004
    }
}
```

**Quando usar double:**
- Cálculos científicos
- Cálculos financeiros (com BigDecimal para maior precisão)
- **É o padrão para números decimais em Java**

## Tipo Lógico

### 7. boolean

Representa verdadeiro ou falso.

```java
public class BooleanExample {
    public static void main(String[] args) {
        boolean ativo = true;
        boolean encerrado = false;
        boolean maiorDeIdade = (25 >= 18);
        
        System.out.println("Ativo: " + ativo);            // true
        System.out.println("Encerrado: " + encerrado);    // false
        System.out.println("Maior de idade: " + maiorDeIdade);  // true
        
        // Operações lógicas
        boolean a = true;
        boolean b = false;
        
        System.out.println("AND: " + (a && b));  // false
        System.out.println("OR: " + (a || b));   // true
        System.out.println("NOT: " + (!a));       // false
        
        // Uso em estruturas de controle
        if (maiorDeIdade) {
            System.out.println("Pode entrar!");
        } else {
            System.out.println("Entrada proibida!");
        }
    }
}
```

## Tipo Caractere

### 8. char (2 bytes)

Representa um único caractere Unicode.

```java
public class CharExample {
    public static void main(String[] args) {
        char letra = 'A';
        char numero = '5';
        char simbolo = '@';
        char unicode = '\u0041';  // 'A' em Unicode
        
        System.out.println("Letra: " + letra);      // A
        System.out.println("Número: " + numero);     // 5
        System.out.println("Símbolo: " + simbolo);   // @
        System.out.println("Unicode: " + unicode);   // A
        
        // Caracteres especiais
        char tabulacao = '\t';
        char novaLinha = '\n';
        char aspa = '\'';
        
        // Conversões
        int codigoAscii = (int) letra;
        System.out.println("Código ASCII de 'A': " + codigoAscii);  // 65
        
        char proximaLetra = (char) (letra + 1);
        System.out.println("Próxima letra: " + proximaLetra);  // B
        
        // Tabela de caracteres
        System.out.println("\nTabela de caracteres:");
        for (char c = 'A'; c <= 'Z'; c++) {
            System.out.print(c + " ");
        }
    }
}
```

## Wrapper Classes

Cada tipo primitivo tem uma **classe wrapper** correspondente:

| Primitivo | Wrapper | Métodos Úteis |
|-----------|---------|---------------|
| byte | Byte | byteValue(), parseByte() |
| short | Short | shortValue(), parseShort() |
| int | Integer | parseInt(), MAX_VALUE, MIN_VALUE |
| long | Long | parseLong(), MAX_VALUE, MIN_VALUE |
| float | Float | parseFloat(), MAX_VALUE |
| double | Double | parseDouble(), MAX_VALUE |
| boolean | Boolean | parseBoolean(), TRUE, FALSE |
| char | Character | isDigit(), isLetter(), toUpperCase() |

### Exemplo com Wrapper Classes

```java
public class WrapperExample {
    public static void main(String[] args) {
        // Autoboxing - conversão automática
        Integer numero = 42;  // int → Integer
        Double preco = 19.99; // double → Double
        Boolean ativo = true; // boolean → Boolean
        
        // Unboxing - conversão automática
        int n = numero;       // Integer → int
        double p = preco;     // Double → double
        boolean a = ativo;    // Boolean → boolean
        
        // Métodos úteis
        String texto = "123";
        int valor = Integer.parseInt(texto);  // String → int
        
        System.out.println("Máximo int: " + Integer.MAX_VALUE);
        System.out.println("Mínimo int: " + Integer.MIN_VALUE);
        System.out.println("String para int: " + valor);
        
        // Converte para outras bases
        int hexadecimal = Integer.parseInt("FF", 16);  // 255
        int binario = Integer.parseInt("1010", 2);     // 10
        System.out.println("Hex FF → " + hexadecimal);
        System.out.println("Bin 1010 → " + binario);
    }
}
```

## Tipos de Referência

Diferente dos primitivos, **tipos de referência** armazenam endereços de memória.

### Classes

```java
public class ReferenceExample {
    public static void main(String[] args) {
        // String é um tipo de referência
        String nome = "Java";
        String copia = nome;  // Ambas apontam para o mesmo objeto
        
        // Arrays são tipos de referência
        int[] numeros = {1, 2, 3, 4, 5};
        
        // Objetos são tipos de referência
        Pessoa pessoa = new Pessoa("João", 25);
        
        System.out.println("Nome: " + nome);
        System.out.println("Array: " + numeros[0]);
        System.out.println("Pessoa: " + pessoa.getNome());
    }
}

class Pessoa {
    private String nome;
    private int idade;
    
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
    
    public String getNome() {
        return nome;
    }
}
```

## Comparação: Primitivo vs Referência

| Característica | Primitivo | Referência |
|----------------|-----------|------------|
| **Armazena** | Valor direto | Endereço de memória |
| **Tamanho** | Fixo (1-8 bytes) | Variável |
| **Padrão** | 0, 0.0, false, '\u0000' | null |
| **Performance** | Mais rápido | Mais lento |
| **Uso de memória** | Menos | Mais |
| **Exemplo** | `int x = 5;` | `String s = "texto";` |

## Tabela Resumo de Memória

```
┌─────────────────────────────────────────────────────────────┐
│                    MEMÓRIA JAVA                              │
├─────────────────────────────────────────────────────────────┤
│                                                             │
│  byte    ■ (1 byte)                                         │
│                                                             │
│  short   ■ ■ (2 bytes)                                      │
│                                                             │
│  int     ■ ■ ■ ■ (4 bytes)                                  │
│                                                             │
│  long    ■ ■ ■ ■ ■ ■ ■ ■ (8 bytes)                          │
│                                                             │
│  float   ■ ■ ■ ■ (4 bytes)                                  │
│                                                             │
│  double  ■ ■ ■ ■ ■ ■ ■ ■ (8 bytes)                          │
│                                                             │
│  boolean ■ (1 bit*)                                         │
│                                                             │
│  char    ■ ■ (2 bytes) - Unicode                            │
│                                                             │
│  Ref.    ■ ■ ■ ■ (4 ou 8 bytes) - Endereço de memória      │
│                                                             │
└─────────────────────────────────────────────────────────────┘
```

## Boas Práticas

### 1. Use o tipo correto para a necessidade

```java
// ❌ Ruim - usando byte para idade de pessoas
byte idade = 150;  // Overflow se idade > 127

// ✅ Bom - usando int para idade
int idade = 150;
```

### 2. Prefira int para inteiros

```java
// ❌ Evitar - complicado sem necessidade
short quantidade = 100;

// ✅ Melhor - padrão do Java
int quantidade = 100;
```

### 3. Use double para decimais

```java
// ❌ Evitar - menos preciso
float preco = 19.99f;

// ✅ Melhor - mais preciso
double preco = 19.99;
```

### 4. Considere BigDecimal para finanças

```java
import java.math.BigDecimal;

// ❌ Problemas de precisão
double saldo = 0.1 + 0.2;  // 0.30000000000000004

// ✅ Precisão exata
BigDecimal saldo = new BigDecimal("0.1")
    .add(new BigDecimal("0.2"));  // 0.3
```

## Resumo

| Tipo | Tamanho | Uso Principal |
|------|---------|---------------|
| **byte** | 1 byte | Dados binários, economia de memória |
| **short** | 2 bytes | Compatibilidade, economia de memória |
| **int** | 4 bytes | **Padrão para inteiros** |
| **long** | 8 bytes | Números muito grandes, timestamps |
| **float** | 4 bytes | Economia de memória, gráficos |
| **double** | 8 bytes | **Padrão para decimais** |
| **boolean** | 1 bit | Verdadeiro/falso |
| **char** | 2 bytes | Caracteres Unicode |

Escolha sempre o tipo mais adequado para sua necessidade, considerando **precisão**, **memória** e **performance**!