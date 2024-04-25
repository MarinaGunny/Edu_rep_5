package ru.rest.L5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.rest.L5.entity.TppRefProductRegisterType;

import java.util.List;

public interface TppRefProductRegisterTypeRepo extends JpaRepository<TppRefProductRegisterType, Integer> {
    public TppRefProductRegisterType findByValue(String value);

    public boolean existsByValue(String value);

    //Т.к. связь по значению, нет смысла смотреть в 2 таблицы
    @Query(value = "select * from tpp_ref_product_register_type where product_class_code = ?1 and account_type='Клиентский'", nativeQuery = true)
    public List<TppRefProductRegisterType> findAllByProductCode(String productCode);
}
