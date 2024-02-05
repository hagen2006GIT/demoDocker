package edu.example.demoDocker.service;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.NoSuchElementException;

@Component @Log public class AccountFromPool {
    @Autowired private final AccountPoolService accountPoolService;
    String account;

    public AccountFromPool(AccountPoolService accountPoolService) {
        this.accountPoolService = accountPoolService;
    }
    public String getAccount(String branchCode) {
        try {
            this.account = accountPoolService.GetAccountFromPool(branchCode).split(",")[0];
        } catch (Exception e) {
            throw new NoSuchElementException("Ошибка получения номера счета из AccountPool"
                    +" для подразделения <"+branchCode+">"
            );
        }
        // добавить обновление массива счетов в пуле, чтобы при следующем обращении из пула брался следующий номер
        return this.account;
    }
}
