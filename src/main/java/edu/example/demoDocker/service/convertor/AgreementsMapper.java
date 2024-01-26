package edu.example.demoDocker.service.convertor;

import edu.example.demoDocker.models.Agreements;
import edu.example.demoDocker.service.dto.AgreementsDTO;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface AgreementsMapper {
    Agreements dtoToModel(AgreementsDTO agreementsDTO);
    AgreementsDTO modelToDto(Agreements agreements);
    List<AgreementsDTO> toListDto(List<Agreements> agreements);
}
