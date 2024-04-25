package ru.rest.L5.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "tpp_ref_account_type")
@Getter
@Setter
public class TppRefAccountType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer internal_id;

    @Column(name = "value")
    private String value;

    @Override
    public String toString() {
        return "TppRefAccountType --> record{" +
                "internal_id=" + internal_id +
                ", value='" + value + '\'' +
                '}';
    }
}
