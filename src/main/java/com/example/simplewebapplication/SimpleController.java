package com.example.simplewebapplication;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 * REST-контроллер c двумя энд-пойнтами:
 *  • "/" — приветствие
 *  • "/api/time" — текущее серверное время в формате ISO-8601
 */
@RestController
@RequestMapping("/")
public class SimpleController {

    private final GreetingService greetingService;

    // Через конструктор внедряем сервис
    public SimpleController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    /** Базовый энд-пойнт, текст берётся из GreetingService */
    @GetMapping
    public String index() {
        return greetingService.greet();
    }

    /** Небольшой JSON-ответ с текущим временем */
    @GetMapping("/api/time")
    public Map<String, String> serverTime() {
        return Map.of(
                "serverTime",
                LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
        );
    }
}