package ru.rest.L5.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "agreement")
@Getter
@Setter
public class Agreement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_id")
    private Integer product_id;

    @Column(name = "general_agreement_id")
    private String general_agreement_id;

    @Column(name = "supplementary_agreement_id")
    private String supplementary_agreement_id;

    @Column(name = "arrangement_type")
    private String arrangement_type;

    @Column(name = "sheduler_job_id")
    private Integer sheduler_job_id;

    @Column(name = "number")
    private String number;

    @Column(name = "opening_date")
    private Date opening_date;

    @Column(name = "closing_date")
    private Date closing_date;

    @Column(name = "cancel_date")
    private Date cancel_date;

    @Column(name = "validity_duration")
    private Integer validity_duration;

    @Column(name = "cancellation_reason")
    private String cancellation_reason;

    @Column(name = "status")
    private String status;

    @Column(name = "interest_calculation_date")
    private Date interest_calculation_date;

    @Column(name = "interest_rate")
    private BigDecimal interest_rate;

    @Column(name = "coefficient")
    private BigDecimal coefficient;

    @Column(name = "coefficient_action")
    private String coefficient_action;

    @Column(name = "minimum_interest_rate")
    private BigDecimal minimum_interest_rate;

    @Column(name = "minimum_interest_rate_coefficient")
    private BigDecimal minimum_interest_rate_coefficient;

    @Column(name = "minimum_interest_rate_coefficient_action")
    private String minimum_interest_rate_coefficient_action;

    @Column(name = "maximal_interest_rate")
    private BigDecimal maximal_interest_rate;

    @Column(name = "maximal_interest_rate_coefficient")
    private BigDecimal maximal_interest_rate_coefficient;

    @Column(name = "maximal_interest_rate_coefficient_action")
    private String maximal_interest_rate_coefficient_action;

    public  Agreement(String general_agreement_id, String number){
        this.general_agreement_id = general_agreement_id;
        this.number = number;
    };
}
