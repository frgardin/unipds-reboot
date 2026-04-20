package dev.unipds.network.domain;

import java.math.BigDecimal;

public class Product {

    private final Long id;
    private final String name;
    private final String description;
    private final BigDecimal price;
    private final String category;
    private final int stockQuantity;

    private Product(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.price = builder.price;
        this.category = builder.category;
        this.stockQuantity = builder.stockQuantity;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public BigDecimal getPrice() { return price; }
    public String getCategory() { return category; }
    public int getStockQuantity() { return stockQuantity; }

    public static class Builder {
        private Long id;
        private String name;
        private String description;
        private BigDecimal price;
        private String category;
        private int stockQuantity;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder name(String name) { this.name = name; return this; }
        public Builder description(String description) { this.description = description; return this; }
        public Builder price(BigDecimal price) { this.price = price; return this; }
        public Builder category(String category) { this.category = category; return this; }
        public Builder stockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; return this; }

        public Product build() { return new Product(this); }
    }
}
