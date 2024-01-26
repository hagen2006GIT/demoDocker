package edu.example.demoDocker.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tpp_ref_account_type") // ГС (Генератор Счетов)
public class TppRefAccountType {
    @Id @Column(name = "id") @GeneratedValue(strategy= GenerationType.IDENTITY) private Long internal_id;
    @Column(name = "value") private String value;
}
