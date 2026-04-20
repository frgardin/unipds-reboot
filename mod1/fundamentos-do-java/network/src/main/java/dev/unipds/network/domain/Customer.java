package dev.unipds.network.domain;

public class Customer {

    private final Long id;
    private final String name;
    private final String email;
    private final String phone;
    private final Address address;

    private Customer(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.email = builder.email;
        this.phone = builder.phone;
        this.address = builder.address;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public Address getAddress() { return address; }

    public static class Builder {
        private Long id;
        private String name;
        private String email;
        private String phone;
        private Address address;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder name(String name) { this.name = name; return this; }
        public Builder email(String email) { this.email = email; return this; }
        public Builder phone(String phone) { this.phone = phone; return this; }
        public Builder address(Address address) { this.address = address; return this; }

        public Customer build() { return new Customer(this); }
    }
}
