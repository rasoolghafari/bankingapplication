package com.rasoolghafari.bankingapplication.repository;

import com.rasoolghafari.bankingapplication.model.Customer;
import com.rasoolghafari.bankingapplication.model.LegalCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}