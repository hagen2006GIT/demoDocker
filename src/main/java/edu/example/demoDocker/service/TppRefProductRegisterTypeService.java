package edu.example.demoDocker.service;

import edu.example.demoDocker.models.TppRefProductRegisterType;
import edu.example.demoDocker.service.dto.TppRefProductRegisterTypeDTO;
import java.util.List;

public interface TppRefProductRegisterTypeService {
    List<TppRefProductRegisterTypeDTO> findAll();
    List<TppRefProductRegisterType> findAllByValue(String value);
}
