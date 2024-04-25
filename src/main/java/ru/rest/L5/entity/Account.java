package ru.rest.L5.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "account_number")
    private String account_number;

    @Column(name = "bussy")
    private boolean bussy;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "account_pool_id")

    private AccountPool account_pool_id;

    public Account(String account_number, AccountPool account_pool) {
        this.account_number = account_number;
        this.bussy = false;
        this.account_pool_id = account_pool;
    }

}
