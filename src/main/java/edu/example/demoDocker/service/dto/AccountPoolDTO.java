package edu.example.demoDocker.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountPoolDTO {
    private Long id;
    private String branch_code;
    private String currency_code;
    private String mdm_ode;
    private String priority_code;
    private String registry_type_code;
    private String[] accounts;
}
