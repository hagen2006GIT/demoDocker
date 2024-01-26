package edu.example.demoDocker.service.impl;

import edu.example.demoDocker.repository.AgreementRepository;
import edu.example.demoDocker.service.AgrService;
import edu.example.demoDocker.service.convertor.AgreementsMapper;
import edu.example.demoDocker.service.dto.AgreementsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AgrServiceImpl implements AgrService {
    private final AgreementRepository agreementRepository;
    private final AgreementsMapper agreementsMapper;

    @Override public List<AgreementsDTO> findAll() {
        return agreementsMapper.toListDto(agreementRepository.findAll());
    }
}
