package edu.example.demoDocker.controller;

import edu.example.demoDocker.models.TppProduct;
import edu.example.demoDocker.models.request.RequestBodyForProduct;
import edu.example.demoDocker.models.response.ResponseBodyForProduct;
import edu.example.demoDocker.repository.TppProductRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    @Autowired final TppProductRepository tppProductRepository;
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

        return ResponseEntity.status(HttpStatus.OK).body(requestBodyForProduct);
    }
    @PostMapping(value = "corporate-settlement-instance/create")
    public ResponseEntity<ResponseBodyForProduct> create(@Valid @RequestBody RequestBodyForProduct requestBodyForProduct){
        return ResponseEntity.status(HttpStatus.OK).body(ResponseBodyForProduct.Of("158"));
    }
}
