package edu.example.demoDocker.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TppRefAccountTypeDTO {
    private Long internal_id;
    private String value;

    public Long getId() {
        return internal_id;
    }
}
