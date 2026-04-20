package dev.unipds.network.database.mock;

import java.util.ArrayList;
import java.util.List;

import dev.unipds.network.domain.Address;
import dev.unipds.network.domain.Customer;

public class DatabaseMock {

    private final List<Customer> customers = new ArrayList<>();

    public DatabaseMock(int size) {
        for (int i = 1; i <= size; i++) {
            Address address = new Address.Builder()
                    .street(i + " Main St")
                    .city("City " + i)
                    .state("State " + i)
                    .zipCode("0000" + i)
                    .country("Brazil")
                    .build();

            Customer customer = new Customer.Builder()
                    .id((long) i)
                    .name("Customer " + i)
                    .email("customer" + i + "@email.com")
                    .phone("+55 11 9000" + String.format("%04d", i))
                    .address(address)
                    .build();

            customers.add(customer);
        }
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
