package edu.example.demoDocker.controller;

import edu.example.demoDocker.models.*;
import edu.example.demoDocker.models.request.RequestBodyForProduct;
import edu.example.demoDocker.models.response.ResponseBodyForProduct;
import edu.example.demoDocker.repository.AccountPoolRepository;
import edu.example.demoDocker.repository.TppProductRepository;
import edu.example.demoDocker.repository.TppRefProductRegisterTypeRepository;
import edu.example.demoDocker.service.*;
import edu.example.demoDocker.service.dto.AgreementsDTO;
import edu.example.demoDocker.service.dto.TppProductDTO;
import edu.example.demoDocker.service.dto.TppProductRegisterDTO;
import jakarta.validation.Valid;
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
    @Autowired private final TppRefProductRegisterTypeRepository tppRefProductRegisterTypeRepository;
    @Autowired private final TppProductRegisterService tppProductRegisterService;
    @Autowired private final AccountPoolRepository accountPoolRepository;

    final ProductService productService;
    @PostMapping("corporate-settlement-instance/create")
    public ResponseEntity<ResponseBodyForProduct> create(@Valid @RequestBody RequestBodyForProduct requestBodyForProduct){
        ResponseBodyForProduct responseBodyForProduct=productService.productService(requestBodyForProduct);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseBodyForProduct);
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
