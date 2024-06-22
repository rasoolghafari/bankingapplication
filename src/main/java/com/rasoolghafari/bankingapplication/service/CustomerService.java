package com.rasoolghafari.bankingapplication.service;

import com.rasoolghafari.bankingapplication.dto.CustomerDTO;
import com.rasoolghafari.bankingapplication.exception.ApplicationException;
import com.rasoolghafari.bankingapplication.mapper.CustomerMapper;
import com.rasoolghafari.bankingapplication.model.Customer;
import com.rasoolghafari.bankingapplication.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository repository;
    private final CustomerMapper mapper;
    @Value("#{messages['customerNotFound']}")
    private String customerNotFound;


    public CustomerDTO find(Long id) {
        Optional<Customer> customer = repository.findById(id);
        if (customer.isPresent()) {
            Customer legalCustomer = customer.get();
            return mapper.toDto(legalCustomer);
        }

        throw new ApplicationException(customerNotFound);
    }
}