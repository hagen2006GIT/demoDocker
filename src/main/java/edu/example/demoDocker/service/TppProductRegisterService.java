package edu.example.demoDocker.service;

import edu.example.demoDocker.models.TppProductRegister;
import edu.example.demoDocker.service.dto.TppProductRegisterDTO;
import java.util.List;

public interface TppProductRegisterService {
    List<TppProductRegisterDTO> findAll();
    List<TppProductRegister> findAllByProductIdAndType(Long productId,String type);
}
