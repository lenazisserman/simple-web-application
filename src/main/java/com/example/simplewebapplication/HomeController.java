package com.example.simplewebapplication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

/**
 * MVC‑контроллер, возвращающий HTML‑представление.
 * Показывает пример:
 *  • Model   View
 *  • редирект после POST           */
@Controller
public class HomeController {

    private final GreetingService greetingService;

    public HomeController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    /** GET /hello-view – отрисовываем страницу hello.html */


    /** POST /hello-view – при отправке формы меняем приветствие и делаем redirect */


    @GetMapping("/hello-view")
    public String hello(Model model) {
        // Если после redirect уже пришёл flash-атрибут &laquo;greeting&raquo;,
        // не трогаем его. Иначе — ставим значение по-умолчанию.
        if (!model.containsAttribute("greeting")) {
            model.addAttribute("greeting", greetingService.greet());
        }
        return "hello";
    }

    @PostMapping("/hello-view")
    public String submit(@RequestParam String name,
                         RedirectAttributes redirect) {

        // flash-атрибут проживёт ровно один redirect
        redirect.addFlashAttribute("greeting", "Привет, " + name + "!");
        return "redirect:/hello-view";
    }
}