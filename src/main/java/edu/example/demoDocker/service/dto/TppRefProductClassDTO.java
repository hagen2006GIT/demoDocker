package edu.example.demoDocker.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TppRefProductClassDTO {
    private Long internal_id;
    private String value;
    private String gbl_code;
    private String gbl_name;
    private String product_row_code;
    private String product_row_name;
    private String subclass_code;
    private String subclass_name;
}
