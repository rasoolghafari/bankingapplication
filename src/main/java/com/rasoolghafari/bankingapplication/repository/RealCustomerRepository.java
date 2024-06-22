package com.rasoolghafari.bankingapplication.repository;

import com.rasoolghafari.bankingapplication.model.Customer;
import com.rasoolghafari.bankingapplication.model.RealCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealCustomerRepository extends JpaRepository<RealCustomer, Long> {
}