package com.rasoolghafari.bankingapplication.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("REAL")
@Getter
@Setter
public class RealCustomer extends Customer {
    private String familyName;

    public RealCustomer() {
        super();
    }

    public RealCustomer(Long id, String name, String phoneNumber, String familyName) {
        super(id, name, phoneNumber, CustomerType.REAL);
        this.familyName = familyName;
    }
}