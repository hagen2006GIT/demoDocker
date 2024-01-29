package edu.example.demoDocker.service.impl;

import edu.example.demoDocker.models.TppProductRegister;
import edu.example.demoDocker.repository.TppProductRegisterRepository;
import edu.example.demoDocker.repository.TppProductRepository;
import edu.example.demoDocker.service.TppProductRegisterService;
import edu.example.demoDocker.service.convertor.TppProductMapper;
import edu.example.demoDocker.service.convertor.TppProductRegisterMapper;
import edu.example.demoDocker.service.dto.TppProductDTO;
import edu.example.demoDocker.service.dto.TppProductRegisterDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TppProductRegisterServiceImpl implements TppProductRegisterService {
    private final TppProductRegisterRepository tppProductRegisterRepository;
    private final TppProductRegisterMapper tppProductRegisterMapper;

    @Override public List<TppProductRegisterDTO> findAll() {
        return tppProductRegisterMapper.toListDto(tppProductRegisterRepository.findAll());
    }
    @Override
    public List<TppProductRegister> findAllByProductIdAndType(Long productId, String type) {
        return null;
    }
    @Override @Transactional public TppProductRegisterDTO save (TppProductRegisterDTO tppProductRegisterDTO){
        return tppProductRegisterMapper.modelToDto(tppProductRegisterRepository.save(
                tppProductRegisterMapper.dtoToModel(tppProductRegisterDTO)));
    }
}
