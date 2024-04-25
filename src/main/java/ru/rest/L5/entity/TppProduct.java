package ru.rest.L5.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "tpp_product")
@Getter
@Setter
public class TppProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_code_id")
    private Integer product_code_id;

    @Column(name = "client_id")
    private Integer client_id;

    @Column(name = "type")
    private String type;

    @Column(name = "number")
    private String number;

    @Column(name = "priority")
    private Integer priority;

    @Column(name = "date_of_conclusion")
    private Date date_of_conclusion;

    @Column(name = "start_date_time")
    private Date start_date_time;

    @Column(name = "end_date_time")
    private Date end_date_time;

    @Column(name = "days")
    private Integer days;

    @Column(name = "penalty_rate")
    private BigDecimal penalty_rate;

    @Column(name = "nso")
    private BigDecimal nso;

    @Column(name = "threshold_amount")
    private BigDecimal threshold_amount;

    @Column(name = "requisite_type")
    private String requisite_type;

    @Column(name = "interest_rate_type")
    private String interest_rate_type;

    @Column(name="tax_rate")
    private BigDecimal tax_rate;

    @Column(name = "reasone_close")
    private String reasone_close;

    @Column(name = "state")
    private String state;

    //Можно в Agreement ничего не писать. Поле указать в соответствии с БД (не объект). В @JoinColumn указываем поле из БД!!!
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="product_id")
    private Set<Agreement> agrees;
}
