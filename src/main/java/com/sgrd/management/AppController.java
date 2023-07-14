package com.sgrd.management;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @GetMapping("")
    public String viewIndex() {
        return "index2";
    }

    // @GetMapping("/index2")
    // public String viewNewWeb() {
    // return "index2";
    // }
}
