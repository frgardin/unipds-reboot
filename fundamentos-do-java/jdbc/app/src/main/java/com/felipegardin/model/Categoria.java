package com.felipegardin.model;

import java.util.Arrays;

public enum Categoria {
    ENTRADAS,
    PRATOS_PRINCIPAIS,
    BEBIDAS,
    SOBREMESA;

    public static Categoria from(String categoria) {
        return Arrays.stream(values())
                        .filter(c -> c.name().equalsIgnoreCase(categoria))
                        .findFirst()
                        .orElseThrow(() -> new IllegalStateException("Esta categoria nao eh suportada."));
    }
}
