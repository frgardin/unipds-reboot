package dev.felipegardin.reactiveapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class MockAuthorizationController {
    

    @GetMapping
    public String slowApi() {
        try {
            Thread.sleep(5000);
        }catch (Exception e) {

        }
        return "content";
    }
}
