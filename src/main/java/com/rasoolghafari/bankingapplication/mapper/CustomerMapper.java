package com.rasoolghafari.bankingapplication.mapper;

import com.rasoolghafari.bankingapplication.dto.CustomerDTO;
import com.rasoolghafari.bankingapplication.model.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDTO toDto(Customer entity);
    Customer toEntity(CustomerDTO dto);
}