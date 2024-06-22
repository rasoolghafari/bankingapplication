package com.rasoolghafari.bankingapplication.controllers;

import com.rasoolghafari.bankingapplication.dto.AccountDTO;
import com.rasoolghafari.bankingapplication.service.AccountService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
@SecurityRequirement(name = "bankingapplication")
public class AccountController {
    private final AccountService service;

    @PostMapping
    public ResponseEntity<AccountDTO> createAccount(@RequestBody AccountDTO accountDTO) {
        AccountDTO createdAccount = service.createAccount(accountDTO);
        return ResponseEntity.ok(createdAccount);
    }

    @GetMapping("/list")
    public ResponseEntity<List<AccountDTO>> list() {
        return ResponseEntity.ok(service.list());
    }
}