package edu.example.demoDocker.repository;

import edu.example.demoDocker.models.Agreements;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgreementsRepository extends JpaRepository<Agreements,Long> {
}
