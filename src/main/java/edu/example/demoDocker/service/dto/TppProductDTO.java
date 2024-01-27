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
    private Long generalAgreementId;
    private Long productCodeId;
    private Long clientId;
    private String type;
    private String number;
    private Long priority;
    private Date dateOfConclusion;
    private Date startDateTime;
    private Date endDateTime;
    private Long days;
    private Long penaltyTate;
    private Long nso;
    private Long thresholdAmount;
    private String requisiteType;
    private String interestRateType;
    private Long taxRate;
    private String reasonClose;
    private String state;
}
