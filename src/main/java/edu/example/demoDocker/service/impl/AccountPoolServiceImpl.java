package edu.example.demoDocker.service.impl;

import edu.example.demoDocker.repository.AccountPoolRepository;
import edu.example.demoDocker.service.AccountPoolService;
import edu.example.demoDocker.service.convertor.AccountPoolMapper;
import edu.example.demoDocker.service.dto.AccountPoolDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AccountPoolServiceImpl implements AccountPoolService {
    private final AccountPoolRepository accountPoolRepository;
    private final AccountPoolMapper accountPoolMapper;

    @Override public List<AccountPoolDTO> findAll() {
        return accountPoolMapper.toListDto(accountPoolRepository.findAll());
    }
}
