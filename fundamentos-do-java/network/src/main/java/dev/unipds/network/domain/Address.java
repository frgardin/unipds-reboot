package dev.unipds.network.domain;

public class Address {

    private final String street;
    private final String city;
    private final String state;
    private final String zipCode;
    private final String country;

    private Address(Builder builder) {
        this.street = builder.street;
        this.city = builder.city;
        this.state = builder.state;
        this.zipCode = builder.zipCode;
        this.country = builder.country;
    }

    public String getStreet() { return street; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getZipCode() { return zipCode; }
    public String getCountry() { return country; }

    public static class Builder {
        private String street;
        private String city;
        private String state;
        private String zipCode;
        private String country;

        public Builder street(String street) { this.street = street; return this; }
        public Builder city(String city) { this.city = city; return this; }
        public Builder state(String state) { this.state = state; return this; }
        public Builder zipCode(String zipCode) { this.zipCode = zipCode; return this; }
        public Builder country(String country) { this.country = country; return this; }

        public Address build() { return new Address(this); }
    }
}
