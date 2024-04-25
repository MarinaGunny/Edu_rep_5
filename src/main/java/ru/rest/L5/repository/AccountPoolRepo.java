package ru.rest.L5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.rest.L5.entity.AccountPool;

import java.util.Optional;

public interface AccountPoolRepo extends JpaRepository<AccountPool, Integer> {
    @Query(value = "select * from account_pool where branch_code = ?1 and currency_code = ?2 and mdm_code = ?3 and priority_code = ?4 and registry_type_code = ?5 fetch first 1 rows only", nativeQuery = true)
    public AccountPool findPool(String branch, String curr, String mdm, String priorityCode, String registry);
}
