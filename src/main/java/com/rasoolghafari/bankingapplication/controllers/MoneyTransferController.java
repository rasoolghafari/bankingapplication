package com.rasoolghafari.bankingapplication.controllers;

import com.rasoolghafari.bankingapplication.service.MoneyTransferService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfers")
@SecurityRequirement(name = "bankingapplication")
public class MoneyTransferController {
    private final MoneyTransferService moneyTransferService;

    public MoneyTransferController(MoneyTransferService moneyTransferService) {
        this.moneyTransferService = moneyTransferService;
    }

    @PostMapping
    public ResponseEntity<Boolean> transferMoney(@RequestParam Long fromAccountId, @RequestParam Long toAccountId, @RequestParam double amount) {
        moneyTransferService.transferMoney(fromAccountId, toAccountId, amount);
        return ResponseEntity.ok().build();
    }
}