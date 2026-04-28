package br.com.felipegardin.helloworld.domain;

import java.math.BigDecimal;

public record Product(
    Long id,
    String name,
    String displayName,
    BigDecimal price
) {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String name;
        private String displayName;
        private BigDecimal price;

        private Builder() {}

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder displayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        public Builder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Product build() {
            return new Product(id, name, displayName, price);
        }
    }
}
