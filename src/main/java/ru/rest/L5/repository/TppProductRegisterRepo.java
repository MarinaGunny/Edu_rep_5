package ru.rest.L5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rest.L5.entity.TppProductRegister;

import java.util.List;


public interface TppProductRegisterRepo extends JpaRepository<TppProductRegister, Integer> {

    public List<TppProductRegister> findAllByProductId(Integer id);
}
