package com.smartretail.serviceauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @GetMapping("/health")
    public String health() {
        return "Auth Service is running!";
    }

    @GetMapping("/test")
    public String test() {
        return "Auth Service test endpoint - " + System.currentTimeMillis();
    }

    @GetMapping("/info")
    public String info() {
        return "Auth Service - Port: 8081, Status: UP";
    }
}
