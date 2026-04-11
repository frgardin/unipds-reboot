package dev.unipds.network.domain;

import java.math.BigDecimal;

public class OrderItem {

    private final Product product;
    private final int quantity;
    private final BigDecimal unitPrice;

    private OrderItem(Builder builder) {
        this.product = builder.product;
        this.quantity = builder.quantity;
        this.unitPrice = builder.unitPrice;
    }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public BigDecimal getUnitPrice() { return unitPrice; }

    public BigDecimal subtotal() {
        return unitPrice.multiply(BigDecimal.valueOf(quantity));
    }

    public static class Builder {
        private Product product;
        private int quantity;
        private BigDecimal unitPrice;

        public Builder product(Product product) { this.product = product; return this; }
        public Builder quantity(int quantity) { this.quantity = quantity; return this; }
        public Builder unitPrice(BigDecimal unitPrice) { this.unitPrice = unitPrice; return this; }

        public OrderItem build() { return new OrderItem(this); }
    }
}
