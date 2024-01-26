package edu.example.demoDocker.service.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgreementsDTO {
    private Long id;
    private Long agreement_id;
    private String generalAgreementId;
    private String supplementaryAgreementId;
    private String arrangementType;
    private Long shedulerJobId;
    private String number;
    private Date openingDate;
    private Date closingDate;
    private Date cancelDate;
    private Long validityDuration;
    private String cancellationReason;
    private String status;
    private Date interestCalculationDate;
    private float interestRate;
    private float coefficient;
    private String coefficientAction;
    private float minimumInterestRate;
    private String minimumInterestRateCoefficient;
    private float maximalnterestRate;
    private float maximalnterestRateCoefficient;
    private String maximalnterestRateCoefficientAction;
}
