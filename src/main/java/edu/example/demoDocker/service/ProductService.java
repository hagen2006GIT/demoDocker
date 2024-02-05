package edu.example.demoDocker.service;

import edu.example.demoDocker.models.Status;
import edu.example.demoDocker.models.TppProduct;
import edu.example.demoDocker.models.TppRefProductRegisterType;
import edu.example.demoDocker.models.request.RequestBodyForProduct;
import edu.example.demoDocker.models.response.ResponseBodyForProduct;
import edu.example.demoDocker.service.dto.AgreementsDTO;
import edu.example.demoDocker.service.dto.TppProductDTO;
import edu.example.demoDocker.service.dto.TppProductRegisterDTO;
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
public class ProductService {
    @Autowired private final TppRefProductRegisterTypeService tppRefProductRegisterTypeService;
    @Autowired private final AgreementsService agreementsService;
    @Autowired private final TppProductService tppProductService;
    @Autowired private final TppProductRegisterService tppProductRegisterService;
    @Autowired private final AccountPoolService accountPoolService;
    boolean testCondition=true;

    public ResponseBodyForProduct productService(RequestBodyForProduct requestBodyForProduct) {
// step#2: Проверка таблицы ЭП ("Продукты") на дубли
        Optional<TppProduct> tppProduct=tppProductService.findByNumber(requestBodyForProduct.getContractNumber());
        if(tppProduct.isPresent() && testCondition){
            throw new NoSuchElementException("Параметр ContractNumber № договора"
                    +"<"+tppProduct.get().getNumber()+">"
                    +" уже существует для ЭП с ID "
                    +"<"+tppProduct.get().getId()+">"
            );
        }
// step#3: Проверка таблицы ДС на дубли
        log.info("array instanceArrangements.length = "+String.valueOf(requestBodyForProduct.getInstanceArrangements().length));
        AgreementsDTO[] arrAgr=requestBodyForProduct.getInstanceArrangements();
        StringBuilder doubleOfNumbers= new StringBuilder();
        int cnt=0;
        for (AgreementsDTO agreementsDTO : arrAgr) {
            if(tppProductService.CheckDoubleOfAgreements(agreementsDTO.getNumber())>0){
                doubleOfNumbers.append(agreementsDTO.getNumber()).append("|");
                cnt+=1;
            }
        }
        log.info("cnt = "+cnt+"; "+doubleOfNumbers.toString());
        if(cnt>0 && testCondition){
            throw new DuplicateKeyException("Параметр дополнительного соглашения(сделки) Number "
                    +"<"+doubleOfNumbers+">"
                    +" уже существует для ЭП с ИД (ContractNumber) "
                    +"<"+requestBodyForProduct.getContractNumber()+">"
            );
        }
// step#4: Проверить Каталог Типа регистра на уже существующие связные записи (если не найдены - исключение)
        TppRefProductRegisterType tppRefProductRegisterType=
                tppRefProductRegisterTypeService
                        .findByProductClassCodeAndAccountType(requestBodyForProduct.getProductCode(),1L);
        if(tppRefProductRegisterType==null) {
            throw new NoSuchElementException("КодПродукта"
                    +"<"+requestBodyForProduct.getProductCode()+">"
                    +" не найдено в Каталоге продуктов "
                    +"<PUBLIC.tpp_ref_product_register_type>"
            );
        }
        log.info("tppRefProductRegisterType: " + tppRefProductRegisterType.getRegisterTypeName()); // !!! registerType
// step#5: Добавить строку в таблицу tpp_product, заполнить согласно Request.Body
        TppProductDTO resultTppProduct=tppProductService.save(tppProductModelToDto(requestBodyForProduct));
// step#6: Добавить в таблицу ПР (tpp_product_register)
        TppProductRegisterDTO tppProductRegisterDTO=new TppProductRegisterDTO();
        tppProductRegisterDTO.setProductId(requestBodyForProduct.getInstanceId());
        tppProductRegisterDTO.setType(tppRefProductRegisterType.getRegisterTypeName());
        tppProductRegisterDTO.setAccountId(new AccountFromPool(accountPoolService).getAccount(requestBodyForProduct.getBranchCode()));
        tppProductRegisterDTO.setCurrencyCode(requestBodyForProduct.getIsoCurrencyCode());
        tppProductRegisterDTO.setState(String.valueOf(Status.s1));
        TppProductRegisterDTO resultTppProductRegister=tppProductRegisterService.save(tppProductRegisterDTO);
// step#7: Добавить ДС в таблицу agreements
        for (AgreementsDTO agreementsDTO : arrAgr) {
            AgreementsDTO agreement = agreementsService.save(agreementsDTO);
            log.info(agreement.toString());
        }
        return ResponseBodyForProduct.Of(String.valueOf(resultTppProduct.getId()),arrAgr,new TppProductRegisterDTO[]{resultTppProductRegister});
    }
    public TppProductDTO tppProductModelToDto(RequestBodyForProduct tppProduct) {
        if ( tppProduct == null ) {
            return null;
        }
        TppProductDTO tppProductDTO = new TppProductDTO();
        tppProductDTO.setId( tppProduct.getInstanceId() );
        tppProductDTO.setType( tppProduct.getProductType() );
        tppProductDTO.setNumber( tppProduct.getContractNumber() );
        tppProductDTO.setPriority( tppProduct.getPriority() );
        tppProductDTO.setProductCodeId(tppProduct.getProductCode());
        tppProductDTO.setClientId(tppProduct.getMdmCode());
        tppProductDTO.setThresholdAmount(tppProductDTO.getThresholdAmount());
        return tppProductDTO;
    }
}
