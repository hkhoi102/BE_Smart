package com.smartretail.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping("/health")
    public String health() {
        return "User Service is running!";
    }

    @GetMapping("/test")
    public String test() {
        return "User Service test endpoint - " + System.currentTimeMillis();
    }

    @GetMapping("/info")
    public String info() {
        return "User Service - Port: 8082, Status: UP";
    }
}
