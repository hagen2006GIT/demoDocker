package edu.example.demoDocker.service;

import edu.example.demoDocker.models.TppProduct;
import edu.example.demoDocker.service.dto.TppProductDTO;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TppProductService {
    TppProductDTO save (TppProductDTO tppProduct);
    public Optional<TppProduct> findByNumber(String value);
    int CheckDoubleOfAgreements(@Param("numberAgr") String numberAgr);
    public Optional<TppProduct> findById(Long value);
}
