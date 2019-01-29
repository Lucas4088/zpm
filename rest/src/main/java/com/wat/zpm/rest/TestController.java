package com.wat.zpm.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(TestController.ENDPOINT)
public class TestController {
    public static final String ENDPOINT = "/check";

    @GetMapping
    public String check() {
        return "TEST";
    }
}
