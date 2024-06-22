package com.rasoolghafari.bankingapplication.service;

import com.rasoolghafari.bankingapplication.exception.ApplicationException;
import com.rasoolghafari.bankingapplication.model.Account;
import com.rasoolghafari.bankingapplication.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MoneyTransferService {
    private final AccountRepository accountRepository;

    @Value("#{messages['invalidAccountId']}")
    private String invalidAccountId;

    @Value("#{messages['insufficientBalance']}")
    private String insufficientBalance;

    public synchronized void transferMoney(Long fromAccountId, Long toAccountId, double amount) {
        Optional<Account> fromAccount = accountRepository.findById(fromAccountId);
        Optional<Account> toAccount = accountRepository.findById(toAccountId);

        if (fromAccount.isPresent() && toAccount.isPresent()) {
            Account fAccount = fromAccount.get();
            Account tAccount = toAccount.get();
            if (fAccount.getBalance() >= amount) {
                fAccount.setBalance(fAccount.getBalance() - amount);
                tAccount.setBalance(tAccount.getBalance() + amount);
                accountRepository.save(fAccount);
                accountRepository.save(tAccount);
                log.info("Money transferred successfully");
            } else {
                log.error("Insufficient balance");
                throw new ApplicationException(insufficientBalance);
            }
        } else {
            log.error("Invalid account id");
            throw new ApplicationException(invalidAccountId);
        }
    }
}