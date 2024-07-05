package com.oAuth2.controller;

import org.springframework.http.HttpHeaders;

import org.springframework.web.bind.annotation.*;


@RestController
public class Controller {

    @GetMapping(value = "/principal")
    public String processor(@RequestHeader HttpHeaders headers){
        return "123";
    }


}
