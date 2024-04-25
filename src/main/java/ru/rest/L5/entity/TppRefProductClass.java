package ru.rest.L5.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tpp_ref_product_class")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TppRefProductClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer internal_id;

    @Column(name = "value")
    private String value;

    @Column(name = "gbi_code")
    private String gbi_code;

    @Column(name = "gbi_name")
    private String gbi_name;

    @Column(name = "product_row_code")
    private String product_row_code;

    @Column(name = "product_row_name")
    private String product_row_name;

    @Column(name = "subclass_code")
    private String subclass_code;

    @Column(name = "subclass_name")
    private String subclass_name;

    @Override
    public String toString() {
        return "TppRefProductClass --> record{" +
                "internal_id=" + internal_id +
                ", value='" + value + '\'' +
                ", gbi_code='" + gbi_code + '\'' +
                ", gbi_name='" + gbi_name + '\'' +
                ", product_row_code='" + product_row_code + '\'' +
                ", product_row_name='" + product_row_name + '\'' +
                ", subclass_code='" + subclass_code + '\'' +
                ", subclass_name='" + subclass_name + '\'' +
                '}';
    }
}
