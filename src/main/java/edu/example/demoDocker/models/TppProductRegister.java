package edu.example.demoDocker.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tpp_product_register") // ПР (Продуктовый регистр)
@ToString
public class TppProductRegister {
    @Id @Column(name = "id") @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @Column(name = "product_id") private Long productId;
    @Column(name = "type") private String type;
    @Column(name = "account_id") private String accountId;
    @Column(name = "currency_code") private String currencyCode;
    @Column(name = "state") private String state;
}
