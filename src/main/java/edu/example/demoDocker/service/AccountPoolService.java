package edu.example.demoDocker.service;

import edu.example.demoDocker.service.dto.AccountPoolDTO;
import java.util.List;

public interface AccountPoolService {
    List<AccountPoolDTO> findAll ();
}
