package edu.example.demoDocker.service.convertor;

import edu.example.demoDocker.models.AccountPool;
import edu.example.demoDocker.service.dto.AccountPoolDTO;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountPoolMapper {
        AccountPool dtoToModel(AccountPoolDTO accountPoolDTO);
        AccountPoolDTO modelToDto(AccountPool accountPool);
        List<AccountPoolDTO> toListDto(List<AccountPool> account);
}
