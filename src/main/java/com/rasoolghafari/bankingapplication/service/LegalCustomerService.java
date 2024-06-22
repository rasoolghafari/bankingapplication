package com.rasoolghafari.bankingapplication.service;

import com.rasoolghafari.bankingapplication.dto.LegalCustomerDTO;
import com.rasoolghafari.bankingapplication.exception.ApplicationException;
import com.rasoolghafari.bankingapplication.mapper.LegalCustomerMapper;
import com.rasoolghafari.bankingapplication.model.LegalCustomer;
import com.rasoolghafari.bankingapplication.repository.LegalCustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LegalCustomerService {
    private final LegalCustomerRepository repository;
    private final LegalCustomerMapper mapper;
    @Value("#{messages['customerNotFound']}")
    private String customerNotFound;

    public LegalCustomerDTO createCustomer(LegalCustomerDTO customerDTO) {
        LegalCustomer customer = repository.save(mapper.toEntity(customerDTO));

        return mapper.toDto(customer);
    }

    public LegalCustomerDTO find(Long id) {
        Optional<LegalCustomer> customer = repository.findById(id);
        if (customer.isPresent()) {
            LegalCustomer legalCustomer = customer.get();
            return mapper.toDto(legalCustomer);
        }

        throw new ApplicationException(customerNotFound);
    }

    public List<LegalCustomerDTO> list() {
        return mapper.toDtos(repository.findAll());
    }
}