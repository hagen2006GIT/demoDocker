package edu.example.demoDocker.controller;

import edu.example.demoDocker.models.TppProduct;
import edu.example.demoDocker.models.request.RequestBodyForProduct;
import edu.example.demoDocker.models.response.ResponseBodyForProduct;
import edu.example.demoDocker.repository.TppProductRepository;
import edu.example.demoDocker.service.AgreementsService;
import edu.example.demoDocker.service.TppProductService;
import edu.example.demoDocker.service.dto.AgreementsDTO;
import edu.example.demoDocker.service.dto.TppProductDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Optional;

// ЭП.СОЗДАНИЕ.POST corporate-settlement-instance/create
// Метод POST corporate-settlement-instance/create предназначен для создания нового объекта ЭКЗЕМПЛЯР ПРОДУКТА (ЭП)
// POST: http://localhost:8181/corporate-settlement-instance/create

@RestController
@RequiredArgsConstructor
@Validated
@Log
public class ProductController {
    @Autowired private final TppProductRepository tppProductRepository;
    @Autowired private final AgreementsService agreementsService;
    @Autowired private final TppProductService tppProductService;

    @PostMapping("corporate-settlement-instance/test")
    public ResponseEntity<RequestBodyForProduct> test(@Valid @RequestBody RequestBodyForProduct requestBodyForProduct){
// step#2: Проверка таблицы ЭП ("Продукты") на дубли
        Optional<TppProduct> tppProduct=tppProductRepository.findByNumber(requestBodyForProduct.getContractNumber());
        if(tppProduct.isPresent()){
            throw new NoSuchElementException("Параметр ContractNumber № договора"
                    +"<"+tppProduct.get().getNumber()+">"
                    +" уже существует для ЭП с ID "
                    +"<"+tppProduct.get().getId()+">"
            );
        }
// Добавить ДС в таблицу agreements
        log.info("array instanceArrangements.length = "+String.valueOf(requestBodyForProduct.getInstanceArrangements().length));
        AgreementsDTO[] arrAgr=requestBodyForProduct.getInstanceArrangements();
        for (int i = 0; i < arrAgr.length; i++) {
            AgreementsDTO agreement=agreementsService.save(arrAgr[i]);
            log.info(agreement.toString());
        }
// Добавить ПР в таблицу tpp_product
        tppProductService.save(tppProductModelToDto(requestBodyForProduct));
//
        return ResponseEntity.status(HttpStatus.OK).body(requestBodyForProduct);
    }
    @PostMapping(value = "corporate-settlement-instance/create")
    public ResponseEntity<ResponseBodyForProduct> create(@Valid @RequestBody RequestBodyForProduct requestBodyForProduct){
        return ResponseEntity.status(HttpStatus.OK).body(ResponseBodyForProduct.Of("158"));
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

        return tppProductDTO;
    }
}
