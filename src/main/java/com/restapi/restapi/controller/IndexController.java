package com.restapi.restapi.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String sayHello() {
        return "Hi selamat datang ke index controller nazmi notes app, can create new note by making a POST request to /notes endpoint";
    }
}