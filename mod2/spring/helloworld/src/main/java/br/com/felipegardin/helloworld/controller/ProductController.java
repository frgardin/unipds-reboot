package br.com.felipegardin.helloworld.controller;

import br.com.felipegardin.helloworld.domain.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final List<Product> database;

    public ProductController() {
        database = new ArrayList<>() {{
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
        }};
    }

    @GetMapping
    public List<Product> findAll() {
        return database;
    }
}
