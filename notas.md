# Notas - Aula 1

Hello World

```java

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
```

Classe precisa ter o mesmo nome do arquivo.

## Fluxograma: Java para Código de Máquina JVM

```mermaid
flowchart TD
    A[Código Fonte Java<br/>.java] --> B[Compilador Java<br/>javac]
    B --> C[Bytecode<br/>.class]
    C --> D[JVM<br/>Java Virtual Machine]
    D --> E{Execução}
    E --> F[Interpretador]
    E --> G[JIT Compiler<br/>Just-In-Time]
    F --> H[Código de Máquina]
    G --> H
    H --> I[Execução na CPU]
    
    style A fill:#e1f5fe
    style C fill:#fff3e0
    style D fill:#f3e5f5
    style H fill:#e8f5e8
    style I fill:#e8f5e8
```

