package ru.rest.L5.Check;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.rest.L5.dto.TppProductRegisterRequestDto;
import ru.rest.L5.entity.TppProductRegister;
import ru.rest.L5.exceptions.BadReqEcxeption;
import ru.rest.L5.repository.TppProductRegisterRepo;

import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier("Step_2")
public class Step_2 implements CheckerAccount{

    @Autowired
    private TppProductRegisterRepo repo;
    @Override
    public void Check(TppProductRegisterRequestDto dto) {

        List<TppProductRegister> list = repo.findAllByProductId(dto.instanceId());

        if (!list.isEmpty()){

            list.forEach((TppProductRegister pr) -> {
                if (pr.getType().equals(dto.registryTypeCode())) {
                    throw new BadReqEcxeption("Параметр registryTypeCode тип регистра " + dto.registryTypeCode() + " уже существует для ЭП с ИД  " + dto.instanceId());
                }
            });
        }
    }
}
