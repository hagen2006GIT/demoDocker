package edu.example.demoDocker.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TppProductRegisterDTO {
    private Long id;
    private Long product_id;
    private String type;
    private Long account_id;
    private String currency_code;
    private String state;
}
