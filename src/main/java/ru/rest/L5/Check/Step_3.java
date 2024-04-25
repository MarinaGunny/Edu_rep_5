package ru.rest.L5.Check;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.rest.L5.dto.TppProductRegisterRequestDto;
import ru.rest.L5.exceptions.BadReqEcxeption;
import ru.rest.L5.exceptions.NotFoundException;
import ru.rest.L5.repository.TppRefProductRegisterTypeRepo;

@Service
@Qualifier("Step_3")
public class Step_3 implements CheckerAccount {

    @Autowired
    private TppRefProductRegisterTypeRepo repo;

    @Override
    public void Check(TppProductRegisterRequestDto dto) {
    if (!repo.existsByValue(dto.registryTypeCode())){
        throw new NotFoundException(" Код Продукта " + dto.registryTypeCode() + " не найден в Каталоге продуктов  для данного типа Регистра");
    }
    }
}
