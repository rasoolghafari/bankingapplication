package com.rasoolghafari.bankingapplication.mapper;

import com.rasoolghafari.bankingapplication.dto.AccountDTO;
import com.rasoolghafari.bankingapplication.model.Account;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CustomerMapper.class})
public interface AccountMapper {
    AccountDTO toDto(Account entity);

    Account toEntity(AccountDTO dto);

    List<AccountDTO> toDtos(List<Account> entity);

    List<Account> toEntities(List<AccountDTO> dto);
}