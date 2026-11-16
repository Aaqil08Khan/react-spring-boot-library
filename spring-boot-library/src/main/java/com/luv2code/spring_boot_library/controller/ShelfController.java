package com.luv2code.spring_boot_library.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.spring_boot_library.responsemodels.ShelfCurrentLoansResponse;
import com.luv2code.spring_boot_library.responsemodels.ShelfHistoryResponse;
import com.luv2code.spring_boot_library.service.ShelfService;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/shelf")
public class ShelfController {

    private final ShelfService shelfService;

    public ShelfController(ShelfService shelfService) {
        this.shelfService = shelfService;
    }

    @GetMapping("/loans")
    @ResponseStatus(HttpStatus.OK)
    public Page<ShelfCurrentLoansResponse> currentLoans(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            Authentication authentication) throws Exception {
        Jwt jwt = (Jwt) authentication.getPrincipal();
        String userEmail = jwt.getClaimAsString("email");

        return shelfService.currentLoans(userEmail, page, size);
    }

    @PutMapping("/return/{bookId}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, String> returnBook(
            @PathVariable Long bookId,
            Authentication authentication) throws Exception {
        Jwt jwt = (Jwt) authentication.getPrincipal();
        String userEmail = jwt.getClaimAsString("email");

        shelfService.returnBook(userEmail, bookId);
        return Map.of("message", "Book returned successfully");
    }

    @GetMapping("/history")
    @ResponseStatus(HttpStatus.OK)
    public Page<ShelfHistoryResponse> loansHistory(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            Authentication authentication) throws Exception {
        Jwt jwt = (Jwt) authentication.getPrincipal();
        String userEmail = jwt.getClaimAsString("email");

        return shelfService.loansHistory(userEmail, page, size);
    }

}
