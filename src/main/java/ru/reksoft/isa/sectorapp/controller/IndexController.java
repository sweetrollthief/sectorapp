package ru.reksoft.isa.sectorapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String sectorForm() {
        System.out.println();

        return "form.html";
    }
}
