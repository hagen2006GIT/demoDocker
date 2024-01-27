package edu.example.demoDocker.service.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AgreementsDTO {
    private Long id;
//    private Long agreementId;
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
    private float minimumInterestRateCoefficient;
    private String minimumInterestRateCoefficientAction;
    private float maximalInterestRate;
    private float maximalInterestRateCoefficient;
    private String maximalInterestRateCoefficientAction;
}
