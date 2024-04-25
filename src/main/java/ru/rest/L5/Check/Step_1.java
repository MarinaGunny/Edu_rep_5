package ru.rest.L5.Check;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.rest.L5.dto.TppProductRegisterRequestDto;
import ru.rest.L5.exceptions.BadReqEcxeption;

@Service
@Qualifier("Step_1")
public class Step_1 implements  CheckerAccount{
    @Override
    public void Check(TppProductRegisterRequestDto dto) {
        if (dto.instanceId() == null) {
            throw new BadReqEcxeption("Имя обязательного параметра instanceId не заполнено");
        }
    }
}
