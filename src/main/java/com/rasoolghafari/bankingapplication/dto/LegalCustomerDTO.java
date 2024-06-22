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
public class LegalCustomerDTO extends CustomerDTO {
    private String faxNumber;

    public LegalCustomerDTO(Long id, String name, String phoneNumber, String faxNumber) {
        super();
        super.setId(id);
        super.setName(name);
        super.setPhoneNumber(phoneNumber);
        this.faxNumber = faxNumber;
        super.setCustomerType(CustomerType.LEGAL);
    }
}