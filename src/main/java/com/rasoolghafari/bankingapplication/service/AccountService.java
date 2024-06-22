package com.rasoolghafari.bankingapplication.service;

import com.rasoolghafari.bankingapplication.dto.AccountDTO;
import com.rasoolghafari.bankingapplication.dto.CustomerDTO;
import com.rasoolghafari.bankingapplication.mapper.AccountMapper;
import com.rasoolghafari.bankingapplication.model.Account;
import com.rasoolghafari.bankingapplication.model.Customer;
import com.rasoolghafari.bankingapplication.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository repository;
    private final CustomerService customerService;
    private final AccountMapper mapper;

    public AccountDTO createAccount(AccountDTO accountDTO) {
        customerService.find(accountDTO.getCustomer().getId());
        Account account = repository.save(mapper.toEntity(accountDTO));
        return mapper.toDto(account);
    }

    public List<AccountDTO> list() {
        return mapper.toDtos(repository.findAll());
    }
}