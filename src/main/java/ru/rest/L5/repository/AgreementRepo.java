package ru.rest.L5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rest.L5.entity.AccountPool;
import ru.rest.L5.entity.Agreement;

public interface AgreementRepo extends JpaRepository<Agreement, Integer> {

    public boolean existsByNumber(String number);
}
