package com.rasoolghafari.bankingapplication.mapper;

import com.rasoolghafari.bankingapplication.dto.LegalCustomerDTO;
import com.rasoolghafari.bankingapplication.dto.RealCustomerDTO;
import com.rasoolghafari.bankingapplication.model.LegalCustomer;
import com.rasoolghafari.bankingapplication.model.RealCustomer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RealCustomerMapper {
    RealCustomerDTO toDto(RealCustomer entity);
    RealCustomer toEntity(RealCustomerDTO dto);
    List<RealCustomerDTO> toDtos(List<RealCustomer> entity);
    List<RealCustomer> toEntities(List<RealCustomerDTO> dto);
}