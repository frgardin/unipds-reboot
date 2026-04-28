package br.com.felipegardin.helloworld.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.felipegardin.helloworld.domain.Product;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final List<Product> database;
    private final AtomicLong lastId;

    public ProductController() {
        database = new ArrayList<>() {
            {
                add(Product.builder()
                        .id(1L)
                        .name("notebook")
                        .displayName("Notebook Pro 15")
                        .price(new BigDecimal("3999.99"))
                        .build());
                add(Product.builder()
                        .id(2L)
                        .name("smartphone")
                        .displayName("Smartphone Ultra X")
                        .price(new BigDecimal("2499.90"))
                        .build());
                add(Product.builder()
                        .id(3L)
                        .name("headphone")
                        .displayName("Wireless Headphone 360")
                        .price(new BigDecimal("349.50"))
                        .build());
            }
        };
        lastId = new AtomicLong(4L);
    }

    @GetMapping
    public List<Product> findAll() {
        return database;
    }

    @PostMapping
    public Product addNewProduct(@RequestBody Product product) {
        Product registeredProduct = new Product(
                lastId.getAndIncrement(),
                product.name(),
                product.displayName(),
                product.price());

        database.add(registeredProduct);

        return registeredProduct;
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        OptionalInt index = IntStream.range(0, database.size())
                .filter(i -> database.get(i).id().equals(id))
                .findFirst();

        if (index.isPresent()) {
            Product productUpdated = Product.builder()
                    .id(id)
                    .name(product.name())
                    .displayName(product.displayName())
                    .price(product.price())
                    .build();

            database.set(index.getAsInt(), productUpdated);
            return productUpdated;
        }

        return addNewProduct(product);
    }

    @DeleteMapping("/{id}")
    public Product delete(@PathVariable Long id) {
        OptionalInt index = IntStream.range(0, database.size())
                .filter(i -> database.get(i).id().equals(id))
                .findFirst();

        if (index.isPresent()) {
            throw new IllegalArgumentException();
        }
        Product productToBeDeleted = database.get(index.getAsInt());

        database.remove(index.getAsInt());
        return productToBeDeleted;
    }
}
