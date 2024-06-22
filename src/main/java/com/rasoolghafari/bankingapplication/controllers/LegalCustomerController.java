package com.rasoolghafari.bankingapplication.controllers;

import com.rasoolghafari.bankingapplication.dto.CustomerDTO;
import com.rasoolghafari.bankingapplication.dto.LegalCustomerDTO;
import com.rasoolghafari.bankingapplication.service.LegalCustomerService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/legal-customers")
@RequiredArgsConstructor
@SecurityRequirement(name = "bankingapplication")
public class LegalCustomerController {
    private final LegalCustomerService service;

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody LegalCustomerDTO customerDTO) {
        LegalCustomerDTO createdCustomer = service.createCustomer(customerDTO);
        return ResponseEntity.ok(createdCustomer);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<LegalCustomerDTO> getCustomerById(@PathVariable Long id) {
        LegalCustomerDTO customer = service.find(id);
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/list")
    public ResponseEntity<List<LegalCustomerDTO>> list() {
        return ResponseEntity.ok(service.list());
    }
}