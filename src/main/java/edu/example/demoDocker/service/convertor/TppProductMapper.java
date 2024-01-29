package edu.example.demoDocker.service.convertor;

import edu.example.demoDocker.models.TppProduct;
import edu.example.demoDocker.service.dto.TppProductDTO;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface TppProductMapper {
        TppProduct dtoToModel(TppProductDTO tppProductDTO);
        TppProductDTO modelToDto(TppProduct tppProduct);
        List<TppProductDTO> toListDto(List<TppProduct> tppProductList);
}
