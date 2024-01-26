package edu.example.demoDocker.service.convertor;

import edu.example.demoDocker.models.TppProductRegister;
import edu.example.demoDocker.service.dto.TppProductRegisterDTO;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface TppProductRegisterMapper {
    TppProductRegister dtoToModel(TppProductRegisterDTO tppProductRegisterDTO);
    TppProductRegisterDTO modelToDto(TppProductRegister tppProductRegister);
    List<TppProductRegisterDTO> toListDto(List<TppProductRegister> tppProductRegisters);
}
