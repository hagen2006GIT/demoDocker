package edu.example.demoDocker.service;

import edu.example.demoDocker.repository.AccountPoolRepository;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component @Log public class AccountFromPool {
    AccountPoolRepository accountPoolRepository;
    String account;

    public AccountFromPool(AccountPoolRepository accountPoolRepository) {
        this.accountPoolRepository = accountPoolRepository;
    }
    public String getAccount(String branchCode) {
        try {
            this.account = accountPoolRepository.GetAccountFromPool(branchCode)[0].split(",")[0];
        } catch (Exception e) {
            throw new NoSuchElementException("Ошибка получения номера счета из AccountPool"
                    +" для подразделения <"+branchCode+">"
            );
        }
        // добавить обновление массива счетов в пуле, чтобы при следующем обращении из пула брался следующий номер
        return this.account;
    }
}
