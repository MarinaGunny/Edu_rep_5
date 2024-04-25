package ru.rest.L5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rest.L5.entity.TppProduct;

public interface TppProductRepo extends JpaRepository<TppProduct, Integer>  {

    public boolean existsByNumber(String number);
}
