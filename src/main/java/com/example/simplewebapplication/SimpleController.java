package com.example.simplewebapplication;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class SimpleController {

    @RequestMapping("/")
    public String index() {
        return "Hello World";
    }
}
