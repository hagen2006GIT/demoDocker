package edu.example.demoDocker.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tpp_ref_product_class")
public class TppRefProductClass {
    @Id @Column(name = "id") @GeneratedValue(strategy= GenerationType.IDENTITY) private Long internal_id;
    @Column(name = "value") private String value;
    @Column(name = "gbl_code") private String gbl_code;
    @Column(name = "gbl_name") private String gbl_name;
    @Column(name = "product_row_code") private String product_row_code;
    @Column(name = "product_row_name") private String product_row_name;
    @Column(name = "subclass_code") private String subclass_code;
    @Column(name = "subclass_name") private String subclass_name;
}
