package edu.example.demoDocker.service;

import edu.example.demoDocker.service.dto.TppRefAccountTypeDTO;
import java.util.List;

public interface TppRefAccountTypeService {
    List<TppRefAccountTypeDTO> findAll();
    TppRefAccountTypeDTO findById(Long id);
    TppRefAccountTypeDTO save(TppRefAccountTypeDTO accType);
    void deleteById(Long id);
}
