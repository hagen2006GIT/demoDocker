package edu.example.demoDocker.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tpp_ref_product_register_type") // Каталог (Регистр) типов продуктов
public class TppRefProductRegisterType {
    @Id @Column(name = "id") @GeneratedValue(strategy = GenerationType.IDENTITY) private Long internal_id;
    @Column(name = "value") private String value;
    @Column(name = "register_type_name") private String register_type_name;
    @Column(name = "product_class_code") private Long product_class_code; //ссылка на tpp_ref_product_class
    @Column(name = "account_type") private Long account_type; //ссылка на tpp_ref_account_type
}
