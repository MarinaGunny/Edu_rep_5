package ru.rest.L5.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "tpp_product_register")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TppProductRegister {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type")
    private String type;

    //Если оставить в переменную как поле, то с подчеркиванием не подойдет для генерации автоматического запроса по имени поля в репозитории
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "account")
    private Integer account;

    @Column(name = "currency_code")
    private String currency_code;

    @Column(name = "state")
    private String state;

    @Column(name = "account_number")
    private String account_number;

}
