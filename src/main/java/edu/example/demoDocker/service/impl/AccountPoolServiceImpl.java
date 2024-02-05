package edu.example.demoDocker.service.impl;

import edu.example.demoDocker.repository.AccountPoolRepository;
import edu.example.demoDocker.service.AccountPoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AccountPoolServiceImpl implements AccountPoolService {
    AccountPoolRepository accountPoolRepository;

    @Override public String GetAccountFromPool(String branchCode) {
        return accountPoolRepository.GetAccountFromPool(branchCode)[0].split(",")[0];
    }
}
