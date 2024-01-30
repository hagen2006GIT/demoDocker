package edu.example.demoDocker.controller;

import edu.example.demoDocker.models.request.RequestBodyForProductRegister;
import edu.example.demoDocker.models.response.ResponseBodyForProductRegistry;
import edu.example.demoDocker.service.ProductRegisterService;
import jakarta.validation.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

// ПР.СОЗДАНИЕ.POST: corporate-settlement-account/create
// Метод POST corporate-settlement-account/create предназначен для создания нового объекта ПРОДУКТОВЫЙ РЕГИСТР (ПР)
// POST: http://localhost:8181/corporate-settlement-account/create

@RestController
@RequiredArgsConstructor
@Validated
@Log
public class ProductRegisterController {
    final ProductRegisterService productRegisterService;
    @PostMapping(value = "corporate-settlement-account/create")
    public ResponseEntity<ResponseBodyForProductRegistry> create(@Valid @RequestBody RequestBodyForProductRegister requestBodyForProductRegister) {
        ResponseBodyForProductRegistry responseBodyForProductRegistry=productRegisterService.productRegistryService(requestBodyForProductRegister);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseBodyForProductRegistry);
    }
}
