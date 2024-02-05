package edu.example.demoDocker.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "agreements") // ДС (сделки)
public class Agreements {
    @Id @Column(name = "id") @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @Column(name = "general_agreement_id") private String generalAgreementId;
    @Column(name = "supplementary_agreement_id") private String supplementaryAgreementId;
    @Column(name = "arrangement_type") private String arrangementType;
    @Column(name = "sheduler_job_id") private Long shedulerJobId;
    @Column(name = "number") private String number;
    @Column(name = "opening_date") private Date openingDate;
    @Column(name = "closing_date") private Date closingDate;
    @Column(name = "cancel_date") private Date cancelDate;
    @Column(name = "validity_duration") private Long validityDuration;
    @Column(name = "cancellation_reason") private String cancellationReason;
    @Column(name = "status") private String status;
    @Column(name = "interest_calculation_date") private Date interestCalculationDate;
    @Column(name = "interest_rate") private float interestRate;
    @Column(name = "coefficient") private float coefficient;
    @Column(name = "coefficient_action") private String coefficientAction;
    @Column(name = "minimumInterest_rate") private float minimumInterestRate;
    @Column(name = "minimumInterest_rate_coefficient") private float minimumInterestRateCoefficient;
    @Column(name = "minimumInterest_rate_coefficient_action") private String minimumInterestRateCoefficientAction;
    @Column(name = "maximal_interest_rate") private float maximalInterestRate;
    @Column(name = "maximal_interest_rate_coefficient") private float maximalInterestRateCoefficient;
    @Column(name = "maximal_interest_rate_coefficient_action") private String maximalInterestRateCoefficientAction;
}
