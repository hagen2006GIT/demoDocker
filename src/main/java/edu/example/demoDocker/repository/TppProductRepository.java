package edu.example.demoDocker.repository;

import edu.example.demoDocker.models.TppProduct;
import edu.example.demoDocker.models.TppRefProductRegisterType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TppProductRepository extends JpaRepository<TppProduct,Long> {
    public Optional<TppProduct> findByNumber(String value);
    public Long countByNumber(String value);
    @Query("select accounts"
            +" from AccountPool"
            +" where branchCode=:branchCode"
            +"      and currencyCode='800'"
            +"      and mdmCode='15'"
            +"      and priorityCode='00'"
            +"      and registryTypeCode='03.012.002_47533_ComSoLd'")
    String[] GetAccountFromPool(@Param("branchCode") String branchCode);}
