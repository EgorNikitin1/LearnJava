package ru.muctr.Task10.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/home")
    public String getHomeString() {
        return "Home page";
    }

    @GetMapping("/sum")
    public Integer getSum(@RequestParam Integer i1, @RequestParam Integer i2) {
        return i1 + i2;
    }

}
