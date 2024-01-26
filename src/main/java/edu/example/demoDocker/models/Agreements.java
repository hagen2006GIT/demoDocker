package edu.example.demoDocker.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "agreements") // ДС (сделки)
public class Agreements {
    @Id @Column(name = "id") @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @Column(name = "agreement_id") private Long agreement_id;
}
