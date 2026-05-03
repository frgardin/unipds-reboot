package dev.felipegardin.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/open")
    public String open() {
        return "open";
    }

    @GetMapping("/closed")
    public String closed() {
        return "closed";
    }
}
