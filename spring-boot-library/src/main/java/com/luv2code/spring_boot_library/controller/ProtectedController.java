package com.luv2code.spring_boot_library.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/protected")
public class ProtectedController {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public String getProtectedRoute() {
        return "Protected Route Granted";
    }
}
