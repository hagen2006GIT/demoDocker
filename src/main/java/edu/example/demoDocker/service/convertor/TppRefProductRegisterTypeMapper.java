package edu.example.demoDocker.service.convertor;

import edu.example.demoDocker.models.TppRefProductRegisterType;
import edu.example.demoDocker.service.dto.TppRefProductRegisterTypeDTO;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface TppRefProductRegisterTypeMapper {
    TppRefProductRegisterType dtoToModel(TppRefProductRegisterTypeDTO tppRefProductRegisterTypeDTO);
    TppRefProductRegisterTypeDTO modelToDto(TppRefProductRegisterType tppRefProductRegisterType);
    List<TppRefProductRegisterTypeDTO> toListDto(List<TppRefProductRegisterType> tppProductRegisters);
}
