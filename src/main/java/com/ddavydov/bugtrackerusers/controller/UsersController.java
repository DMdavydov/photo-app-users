package com.ddavydov.bugtrackerusers.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UsersController {

    private final Environment env;

    @GetMapping("/status/check")
    public String status() {
        return "Working on port" + env.getProperty("local.server.port");
    }
}
