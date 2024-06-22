package com.rasoolghafari.bankingapplication.mapper;

import com.rasoolghafari.bankingapplication.dto.LegalCustomerDTO;
import com.rasoolghafari.bankingapplication.dto.RealCustomerDTO;
import com.rasoolghafari.bankingapplication.model.LegalCustomer;
import com.rasoolghafari.bankingapplication.model.RealCustomer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LegalCustomerMapper {
    LegalCustomerDTO toDto(LegalCustomer entity);
    LegalCustomer toEntity(LegalCustomerDTO dto);
    List<LegalCustomerDTO> toDtos(List<LegalCustomer> entity);
    List<LegalCustomer> toEntities(List<LegalCustomerDTO> dto);
}