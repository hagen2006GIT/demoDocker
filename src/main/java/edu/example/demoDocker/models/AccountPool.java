package edu.example.demoDocker.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account_pool") // Пул счетов
public class AccountPool {
    @Id @Column(name = "id") @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @Column(name = "branch_code") private String branchCode;
    @Column(name = "currency_code") private String currencyCode;
    @Column(name = "mdm_code") private String mdmCode;
    @Column(name = "priority_code") private String priorityCode;
    @Column(name = "registry_type_code") private String registryTypeCode;
    @Column(name = "accounts") private String[] accounts;
}
