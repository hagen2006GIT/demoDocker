package edu.example.demoDocker.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TppRefProductRegisterTypeDTO {
    private Long internalId;
    private String value;
    private String registerTypeName;
    private String productClassCode;
    private Long accountType;
}
