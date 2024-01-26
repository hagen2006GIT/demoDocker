package edu.example.demoDocker.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TppProductDTO {
    private Long id;
    private Long agreement_id;
    private Long product_code_id;
    private Long client_id;
    private String type;
    private String number;
    private Long priority;
    private Date date_of_conclusion;
    private Date start_date_time;
    private Date end_date_time;
    private Long days;
    private Long penalty_rate;
    private Long nso;
    private Long threshold_amount;
    private String requisite_type;
    private String interest_rate_type;
    private Long tax_rate;
    private String reason_close;
    private String state;
}
