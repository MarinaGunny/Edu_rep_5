package ru.rest.L5.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "account_pool")
@Getter
@Setter
public class AccountPool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "branch_code")
    private String branch_code;

    @Column(name = "currency_code")
    private String currency_code;

    @Column(name = "mdm_code")
    private String mdm_code;

    @Column(name = "priority_code")
    private String priority_code;

    @Column(name = "registry_type_code")
    private String registry_type_code;

    //fetch = FetchType.EAGER чтобы не было ошибки LazyInitializationException
    @OneToMany(mappedBy = "account_pool_id", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)

    private Set<Account> accounts;

    public AccountPool(String branch_code, String currency_code, String mdm_code, String registry_type_code) {
        this.branch_code = branch_code;
        this.currency_code = currency_code;
        this.mdm_code = mdm_code;
        this.registry_type_code = registry_type_code;
        this.priority_code = "00";
        this.accounts = new HashSet<>();
    }


}
