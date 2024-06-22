package com.rasoolghafari.bankingapplication.service;

import com.rasoolghafari.bankingapplication.dto.RealCustomerDTO;
import com.rasoolghafari.bankingapplication.exception.ApplicationException;
import com.rasoolghafari.bankingapplication.mapper.RealCustomerMapper;
import com.rasoolghafari.bankingapplication.model.RealCustomer;
import com.rasoolghafari.bankingapplication.repository.RealCustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RealCustomerService {
    private final RealCustomerRepository repository;
    private final RealCustomerMapper mapper;

    @Value("#{messages['customerNotFound']}")
    private String customerNotFound;
    public RealCustomerDTO createCustomer(RealCustomerDTO customerDTO) {
        RealCustomer customer = repository.save(mapper.toEntity(customerDTO));

        return mapper.toDto(customer);
    }

    public RealCustomerDTO find(Long id) {
        Optional<RealCustomer> customer = repository.findById(id);
        if (customer.isPresent()) {
            RealCustomer realCustomer = customer.get();
            return mapper.toDto(realCustomer);
        }
        throw new ApplicationException(customerNotFound);
    }

    public List<RealCustomerDTO> list() {
        return mapper.toDtos(repository.findAll());
    }
}