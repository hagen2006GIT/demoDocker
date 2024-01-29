package edu.example.demoDocker.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TppProductRegisterDTO {
    private Long id;
    private Long productId;
    private String type;
    private String accountId;
    private String currencyCode;
    private String state;
}
