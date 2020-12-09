package com.around.soh.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello2Controller {

    @GetMapping("/hello2")
    public String hello2(){
        return "hello";
    }
}
