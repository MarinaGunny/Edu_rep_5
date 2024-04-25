package ru.rest.L5.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "tpp_ref_product_register_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TppRefProductRegisterType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer internal_id;

    @Column(name = "value")
    private String value;

    @Column(name = "register_type_name")
    private String register_type_name;

    @Column(name = "product_class_code")
    private String product_class_code;

    @Column(name = "register_type_start_date")
    private Date register_type_start_date;

    @Column(name = "register_type_end_date")
    private Date register_type_end_date;

    @Column
    private String account_type;
}
