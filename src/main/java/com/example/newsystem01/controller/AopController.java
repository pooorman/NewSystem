package com.example.newsystem01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aop")
public class AopController {

    @GetMapping("/{name}")
    public String testAop(@PathVariable String name) {
        int i=1/0;
        return "Hello " + name;
    }
}
