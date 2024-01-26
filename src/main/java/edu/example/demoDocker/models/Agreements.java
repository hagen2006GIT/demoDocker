package edu.example.demoDocker.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "agreements") // ДС (сделки)
public class Agreements {
    @Id @Column(name = "id") @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @Column(name = "agreement_id") private Long agreement_id;
    @Column(name = "generalAgreementId") private String generalAgreementId;
    @Column(name = "supplementaryAgreementId") private String supplementaryAgreementId;
    @Column(name = "arrangementType") private String arrangementType;
    @Column(name = "shedulerJobId") private Long shedulerJobId;
    @Column(name = "number") private String number;
    @Column(name = "openingDate") private Date openingDate;
    @Column(name = "closingDate") private Date closingDate;
    @Column(name = "cancelDate") private Date cancelDate;
    @Column(name = "validityDuration") private Long validityDuration;
    @Column(name = "cancellationReason") private String cancellationReason;
    @Column(name = "status") private String status;
    @Column(name = "interestCalculationDate") private Date interestCalculationDate;
    @Column(name = "interestRate") private float interestRate;
    @Column(name = "coefficient") private float coefficient;
    @Column(name = "coefficientAction") private String coefficientAction;
    @Column(name = "minimumInterestRate") private float minimumInterestRate;
    @Column(name = "minimumInterestRateCoefficient") private String minimumInterestRateCoefficient;
    @Column(name = "maximalnterestRate") private float maximalnterestRate;
    @Column(name = "maximalnterestRateCoefficient") private float maximalnterestRateCoefficient;
    @Column(name = "maximalnterestRateCoefficientAction") private String maximalnterestRateCoefficientAction;
}
