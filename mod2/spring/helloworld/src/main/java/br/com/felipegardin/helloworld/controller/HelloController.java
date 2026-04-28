package br.com.felipegardin.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.felipegardin.helloworld.domain.Product;

@RestController
public class HelloController {
    
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World";
    }

    @PostMapping("/product")
    public Product addNewProduct(@RequestBody Product product) {
        System.out.println("Product received");
        return product;
    } 

}
