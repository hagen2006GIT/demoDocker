package edu.example.demoDocker.service.impl;

import edu.example.demoDocker.models.TppRefProductRegisterType;
import edu.example.demoDocker.repository.TppRefProductRegisterTypeRepository;
import edu.example.demoDocker.service.TppRefProductRegisterTypeService;
import edu.example.demoDocker.service.convertor.TppRefProductRegisterTypeMapper;
import edu.example.demoDocker.service.dto.TppRefProductRegisterTypeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TppRefProductRegisterTypeServiceImpl implements TppRefProductRegisterTypeService {
    private final TppRefProductRegisterTypeRepository tppRefProductRegisterTypeRepository;
    private final TppRefProductRegisterTypeMapper tppRefProductRegisterTypeMapper;

    @Override public List<TppRefProductRegisterTypeDTO> findAll() {
        return tppRefProductRegisterTypeMapper.toListDto(tppRefProductRegisterTypeRepository.findAll());
    }
    @Override
    public List<TppRefProductRegisterType> findAllByValue(String value) {
        return null;
    }
}
