package com.rasoolghafari.bankingapplication.dto;

import com.rasoolghafari.bankingapplication.model.CustomerType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RealCustomerDTO extends CustomerDTO {
    private String familyName;

    public RealCustomerDTO(Long id, String name, String phoneNumber, String familyName) {
        super();
        super.setId(id);
        super.setName(name);
        super.setPhoneNumber(phoneNumber);
        this.familyName = familyName;
        super.setCustomerType(CustomerType.REAL);
    }
}