package edu.example.demoDocker.controller;

import edu.example.demoDocker.models.request.RequestBodyForProductRegister;
import edu.example.demoDocker.models.response.ResponseBodyForProductRegistry;
import edu.example.demoDocker.models.TppProduct;
import edu.example.demoDocker.repository.AccountPoolRepository;
import edu.example.demoDocker.repository.TppProductRegisterRepository;
import edu.example.demoDocker.repository.TppProductRepository;
import edu.example.demoDocker.repository.TppRefProductRegisterTypeRepository;
import jakarta.validation.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.NoSuchElementException;
import java.util.Optional;

// ПР.СОЗДАНИЕ.POST: corporate-settlement-account/create
// Метод POST corporate-settlement-account/create предназначен для создания нового объекта ПРОДУКТОВЫЙ РЕГИСТР (ПР)
// POST: http://localhost:8181/corporate-settlement-account/create

@RestController
@RequiredArgsConstructor
@Validated
@Log
public class ProductRegisterController {
    @Autowired final TppProductRegisterRepository tppProductRegisterRepository;
    @Autowired final TppRefProductRegisterTypeRepository tppRefProductRegisterTypeRepository;
    @Autowired final TppProductRepository tppProductRepository;
    @Autowired final AccountPoolRepository accountPoolRepository;

    @PostMapping(value = "corporate-settlement-account/create")
    public ResponseEntity<ResponseBodyForProductRegistry> create(@Valid @RequestBody RequestBodyForProductRegister requestBodyForProductRegister){
// step#2: Проверка таблицы ПР ("Продуктовый регистр") на дубли
        if(tppProductRegisterRepository.Check1(requestBodyForProductRegister.getInstanceId(), requestBodyForProductRegister.getRegistryTypeCode())>0) {
            throw new DuplicateKeyException("Параметр registryTypeCode с типом регистра "
                    + requestBodyForProductRegister.getRegistryTypeCode()
                    +" уже существует для ЭП с ИД (instanceId) "
                    + requestBodyForProductRegister.getInstanceId());
        }
// step#3: поискать связные записи в Каталоге типов регистра (по полю value)
        // поищем в Продуктовом регистре
/*        Optional<TppProduct> tppProd=tppProductRepository.findById(requestBodyForProductRegister.getInstanceId());
        // поищем в Каталоге типов регистра
        if(tppRefProductRegisterTypeRepository.findAllByValue(requestBodyForProductRegister.getRegistryTypeCode()).isEmpty()){
            throw new NoSuchElementException("КодПродукта="
                    +"<"+tppProd.get().getProductCodeId()+">"
                    +" для типа Регистра=<"+ requestBodyForProductRegister.getRegistryTypeCode()+">"
                    +" не найден в Каталоге продуктов "
                    +"<PUBLIC.tpp_ref_product_register_type> "
            );
        }*/
// step#4: получить счет из пула счетов (идентификатор продуктового регистра account_id)
        String accountFirst=accountPoolRepository.GetAccountFromPool(requestBodyForProductRegister.getBranchCode())[0].split(",")[0];
        log.info("accountFromPool="+accountFirst);
// step#5: вернуть ResponseBody с полученным account_id
        return ResponseEntity.status(HttpStatus.OK).body(ResponseBodyForProductRegistry.Of(accountFirst));
    }
}
