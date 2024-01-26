package edu.example.demoDocker.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TppRefProductRegisterTypeDTO {
    private Long internal_id;
    private String value;
    private String register_type_name;
    private String product_class_code;
    private String account_type;
}
