package edu.example.demoDocker.service.impl;

import edu.example.demoDocker.repository.AgreementsRepository;
import edu.example.demoDocker.service.AgreementsService;
import edu.example.demoDocker.service.convertor.AgreementsMapper;
import edu.example.demoDocker.service.dto.AgreementsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AgreementsServiceImpl implements AgreementsService {
    private final AgreementsRepository agreementRepository;
    private final AgreementsMapper agreementsMapper;

    @Override @Transactional public AgreementsDTO save (AgreementsDTO agreement) {
        return agreementsMapper.modelToDto(agreementRepository.save(
                agreementsMapper.dtoToModel(agreement)));
    }
}
