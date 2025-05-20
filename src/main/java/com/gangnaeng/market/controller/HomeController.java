package com.gangnaeng.market.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/items")
    public String home() {
        return "items/home"; //home.mustache
    }
}
