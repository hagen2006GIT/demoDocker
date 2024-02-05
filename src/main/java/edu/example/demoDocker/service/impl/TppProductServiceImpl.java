package edu.example.demoDocker.service.impl;

import edu.example.demoDocker.models.TppProduct;
import edu.example.demoDocker.repository.TppProductRepository;
import edu.example.demoDocker.service.TppProductService;
import edu.example.demoDocker.service.convertor.TppProductMapper;
import edu.example.demoDocker.service.dto.TppProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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
    @Override public Optional<TppProduct> findByNumber(String value) {
        return tppProductRepository.findByNumber(value);

    }
    @Override public int CheckDoubleOfAgreements(String numberAgr) {
        return tppProductRepository.CheckDoubleOfAgreements(numberAgr);
    }

    @Override public Optional<TppProduct> findById(Long value) {
        return tppProductRepository.findById(value);
    }
}
