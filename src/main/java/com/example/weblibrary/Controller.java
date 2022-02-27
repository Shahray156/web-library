package com.example.weblibrary;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")

public class Controller {
    private final Calculator calculator;

    public Controller(Calculator calculator) {
        this.calculator = calculator;
    }

    @GetMapping
    public String greeting() {
        return "Добро пожаловать в великолепный калькулятор";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        return num1 + " + " + num2 + "=" + calculator.plus(num1, num2);
    }

    @GetMapping("/minus")
    public String minus(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        return num1 + " - " + num2 + "=" + calculator.minus(num1, num2);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        return num1 + " * " + num2 + "=" + calculator.multiply(num1, num2);
    }

    @GetMapping("/divide")
    public String divide(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        if(num2==0) {
            return "Нельзя на ноль делить";
        }
        return num1 + " / " + num2 + "=" + calculator.divide(num1, num2);
    }
}