package edu.example.demoDocker.repository;

import edu.example.demoDocker.models.TppProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface TppProductRepository extends JpaRepository<TppProduct,Long> {
    public Optional<TppProduct> findByNumber(String value);
    public Optional<TppProduct> findById(Long value);

    @Query("select count(1)"
            +" from Agreements"
            +" where number=:numberAgr")
    int CheckDoubleOfAgreements(@Param("numberAgr") String numberAgr);
}
