package edu.example.demoDocker.repository;

import edu.example.demoDocker.models.TppProductRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface TppProductRegisterRepository extends JpaRepository<TppProductRegister,Long>{
    List<TppProductRegister> findAllByProductIdAndType(Long productId,String type);
    @Query("select count(1) from TppProductRegister where productId=:instanceId and type=:registryTypeCode")
    int Check1(@Param("instanceId") Long instanceId,@Param("registryTypeCode") String registryTypeCode);
}
