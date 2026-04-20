package com.felipegardin.model;

import java.math.BigDecimal;

public class ItemCardapio {

    private Long id;
    private String nome;
    private String descricao;
    private Categoria categoria;
    private BigDecimal preco;
    private BigDecimal precoPromocional;

    public ItemCardapio() {
    }

    private ItemCardapio(Builder builder) {
        this.id = builder.id;
        this.nome = builder.nome;
        this.descricao = builder.descricao;
        this.categoria = builder.categoria;
        this.preco = builder.preco;
        this.precoPromocional = builder.precoPromocional;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private Long id;
        private String nome;
        private String descricao;
        private Categoria categoria;
        private BigDecimal preco;
        private BigDecimal precoPromocional;

        private Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder descricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public Builder categoria(Categoria categoria) {
            this.categoria = categoria;
            return this;
        }

        public Builder preco(BigDecimal preco) {
            this.preco = preco;
            return this;
        }

        public Builder precoPromocional(BigDecimal precoPromocional) {
            this.precoPromocional = precoPromocional;
            return this;
        }

        public ItemCardapio build() {
            return new ItemCardapio(this);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public BigDecimal getPrecoPromocional() {
        return precoPromocional;
    }

    public void setPrecoPromocional(BigDecimal precoPromocional) {
        this.precoPromocional = precoPromocional;
    }

    @Override
    public String toString() {
        return "ItemCardapio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", categoria=" + categoria +
                ", preco=" + preco +
                ", precoPromocional=" + precoPromocional +
                '}';
    }
}
