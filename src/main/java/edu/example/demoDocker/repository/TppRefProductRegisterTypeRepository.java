package edu.example.demoDocker.repository;

import edu.example.demoDocker.models.TppProductRegister;
import edu.example.demoDocker.models.TppRefProductRegisterType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TppRefProductRegisterTypeRepository extends JpaRepository<TppRefProductRegisterType,Long> {
    TppRefProductRegisterType findByProductClassCodeAndAccountType(String productClassCode, Long accountType);
    TppRefProductRegisterType findAllByValue(String typeCode);
}
