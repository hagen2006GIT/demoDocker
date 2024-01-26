package edu.example.demoDocker.service;

import edu.example.demoDocker.service.dto.AgreementsDTO;
import java.util.List;

public interface AgrService {
    List<AgreementsDTO> findAll ();
}
