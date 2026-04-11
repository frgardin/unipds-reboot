package dev.unipds.network.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Order {

    private final Long id;
    private final Customer customer;
    private final List<OrderItem> items;
    private final OrderStatus status;
    private final LocalDateTime createdAt;

    private Order(Builder builder) {
        this.id = builder.id;
        this.customer = builder.customer;
        this.items = builder.items;
        this.status = builder.status;
        this.createdAt = builder.createdAt;
    }

    public Long getId() { return id; }
    public Customer getCustomer() { return customer; }
    public List<OrderItem> getItems() { return items; }
    public OrderStatus getStatus() { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public BigDecimal total() {
        return items.stream()
                .map(OrderItem::subtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public static class Builder {
        private Long id;
        private Customer customer;
        private List<OrderItem> items;
        private OrderStatus status;
        private LocalDateTime createdAt;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder customer(Customer customer) { this.customer = customer; return this; }
        public Builder items(List<OrderItem> items) { this.items = items; return this; }
        public Builder status(OrderStatus status) { this.status = status; return this; }
        public Builder createdAt(LocalDateTime createdAt) { this.createdAt = createdAt; return this; }

        public Order build() { return new Order(this); }
    }
}
