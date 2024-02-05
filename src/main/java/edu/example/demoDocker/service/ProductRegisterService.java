package edu.example.demoDocker.service;

import edu.example.demoDocker.models.TppProduct;
import edu.example.demoDocker.models.TppRefProductRegisterType;
import edu.example.demoDocker.models.request.RequestBodyForProductRegister;
import edu.example.demoDocker.models.response.ResponseBodyForProductRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Log
@Service
public class ProductRegisterService {
    @Autowired final TppProductRegisterService tppProductRegisterService;
    @Autowired final TppRefProductRegisterTypeService tppRefProductRegisterTypeService;
    @Autowired final TppProductService tppProductService;
    @Autowired final AccountPoolService accountPoolService;

    public ResponseBodyForProductRegistry productRegistryService(RequestBodyForProductRegister requestBodyForProductRegister) {
// step#2: Проверка таблицы ПР ("Продуктовый регистр") на дубли
        if(tppProductRegisterService.Check1(requestBodyForProductRegister.getInstanceId(),requestBodyForProductRegister.getRegistryTypeCode())>0) {
        throw new DuplicateKeyException("Параметр registryTypeCode с типом регистра "
                + requestBodyForProductRegister.getRegistryTypeCode()
                +" уже существует для ЭП с ИД (instanceId) "
                + requestBodyForProductRegister.getInstanceId());
    }
// step#3: поискать связные записи в Каталоге типов регистра (по полю value)
            // поищем в Продуктовом регистре
            Optional<TppProduct> tppProd=tppProductService.findById(requestBodyForProductRegister.getInstanceId());
            Optional<TppRefProductRegisterType> tppRefProductRegisterType=
                    Optional.ofNullable(tppRefProductRegisterTypeService.findAllByValue(requestBodyForProductRegister.getRegistryTypeCode()));
            // поищем в Каталоге типов регистра
            if(tppRefProductRegisterType.isEmpty()){
                throw new NoSuchElementException("КодПродукта="
                        +"<"+tppProd.get().getProductCodeId()+">"
                        +" для типа Регистра=<"+ requestBodyForProductRegister.getRegistryTypeCode()+">"
                        +" не найден в Каталоге продуктов "
                        +"<PUBLIC.tpp_ref_product_register_type> "
                );
            }
// step#4: получить счет из пула счетов (идентификатор продуктового регистра account_id)
        AccountFromPool accountFromPool=new AccountFromPool(accountPoolService);
// step#5: вернуть ResponseBody с полученным account_id
        return ResponseBodyForProductRegistry.Of(accountFromPool.getAccount(requestBodyForProductRegister.getBranchCode()));
    }
}
