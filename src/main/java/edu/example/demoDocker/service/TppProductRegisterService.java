package edu.example.demoDocker.service;

import edu.example.demoDocker.models.TppProductRegister;
import edu.example.demoDocker.service.dto.TppProductRegisterDTO;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TppProductRegisterService {
    List<TppProductRegisterDTO> findAll();
    List<TppProductRegister> findAllByProductIdAndType(Long productId,String type);
    TppProductRegisterDTO save (TppProductRegisterDTO tppProductRegisterDTO);
    int Check1(@Param("instanceId") Long instanceId, @Param("registryTypeCode") String registryTypeCode);
}
