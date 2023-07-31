package com.sgrd.management.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping({ "/index", "/", "/home" })
    public String viewIndex() {
        return "index";
    }
}
