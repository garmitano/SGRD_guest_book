package com.sgrd.management.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    // TODO aca debo cargar una lista con el estado de cada habitacion y mostrarlo
    // al inicio
    @GetMapping("")
    public String viewIndex() {
        return "index2";
    }

    // @GetMapping("/index2")
    // public String viewNewWeb() {
    // return "index2";
    // }
}
