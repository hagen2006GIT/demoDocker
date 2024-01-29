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
@Table(name = "tpp_product") // ЭП (Экземпляр продукта (договор))
public class TppProduct {
    @Id @Column(name = "id") @GeneratedValue(strategy= GenerationType.IDENTITY) private Long id;
    @Column(name = "general_agreement_id") private Long generalAgreementId;
    @Column(name = "product_code_id") private String productCodeId;
    @Column(name = "client_id") private String clientId;
    @Column(name = "type") private String type;
    @Column(name = "number") private String number;
    @Column(name = "priority") private String priority;
    @Column(name = "date_of_conclusion") private Date dateOfConclusion;
    @Column(name = "start_date_time") private Date startDateTime;
    @Column(name = "end_date_time") private Date endDateTime;
    @Column(name = "days") private Long days;
    @Column(name = "penalty_rate") private Long penaltyRate;
    @Column(name = "nso") private Long nso;
    @Column(name = "threshold_amount") private Long thresholdAmount;
    @Column(name = "requisite_type") private String requisiteType;
    @Column(name = "interest_rate_type") private String interestRateType;
    @Column(name = "tax_rate") private Long taxRate;
    @Column(name = "reason_close") private String reasonClose;
    @Column(name = "state") private String state;
}
