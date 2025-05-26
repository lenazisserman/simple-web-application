package com.example.simplewebapplication;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Простой сервис, который возвращает приветствие.
 * Текст можно переопределить через application.properties.
 */
@Service
public class GreetingService {

    // Значение берётся из конфигурации, по-умолчанию "Hello World"
    @Value("${app.greeting:Hello World}")
    private String greeting;

    public String greet() {
        return greeting;
    }
}