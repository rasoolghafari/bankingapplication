package com.rasoolghafari.bankingapplication.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("LEGAL")
@Getter
@Setter
public class LegalCustomer extends Customer {
    private String faxNumber;

    public LegalCustomer() {
        super();
    }

    public LegalCustomer(Long id, String name, String phoneNumber, String faxNumber) {
        super(id, name, phoneNumber, CustomerType.LEGAL);
        this.faxNumber = faxNumber;
    }
}