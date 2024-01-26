package edu.example.demoDocker.service.convertor;

import edu.example.demoDocker.models.TppRefAccountType;
import edu.example.demoDocker.service.dto.TppRefAccountTypeDTO;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface TppRefAccountTypeMapper {
    TppRefAccountType dtoToModel(TppRefAccountTypeDTO tppRefAccountTypeDTO);
    TppRefAccountTypeDTO modelToDto(TppRefAccountType tppRefAccountType);
    List<TppRefAccountTypeDTO> toListDto(List<TppRefAccountType> tppRefAccountTypes);
}