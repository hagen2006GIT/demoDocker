package edu.example.demoDocker.service.impl;

import edu.example.demoDocker.repository.TppProductRepository;
import edu.example.demoDocker.service.TppProductService;
import edu.example.demoDocker.service.convertor.TppProductMapper;
import edu.example.demoDocker.service.dto.TppProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TppProductServiceImpl implements TppProductService {
    private final TppProductRepository tppProductRepository;
    private final TppProductMapper tppProductMapper;

    @Override @Transactional public TppProductDTO save (TppProductDTO tppProductDTO) {
        return tppProductMapper.modelToDto(tppProductRepository.save(
                tppProductMapper.dtoToModel(tppProductDTO)));
    }
}
