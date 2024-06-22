package com.rasoolghafari.bankingapplication.controllers;

import com.rasoolghafari.bankingapplication.dto.RealCustomerDTO;
import com.rasoolghafari.bankingapplication.service.RealCustomerService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/real-customers")
@RequiredArgsConstructor
@SecurityRequirement(name = "bankingapplication")
public class RealCustomerController {
    private final RealCustomerService service;

    @PostMapping
    public ResponseEntity<RealCustomerDTO> createCustomer(@RequestBody RealCustomerDTO customerDTO) {
        RealCustomerDTO createdCustomer = service.createCustomer(customerDTO);
        return ResponseEntity.ok(createdCustomer);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<RealCustomerDTO> getCustomerById(@PathVariable Long id) {
        RealCustomerDTO customer = service.find(id);
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/list")
    public ResponseEntity<List<RealCustomerDTO>> list() {
        return ResponseEntity.ok(service.list());
    }
}