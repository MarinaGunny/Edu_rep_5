package ru.rest.L5.Check;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.rest.L5.dto.InstanceRequestDto;
import ru.rest.L5.exceptions.BadReqEcxeption;
import ru.rest.L5.repository.TppProductRepo;

@Service
@Qualifier("Step_1_1")
public class Step_1_1 implements  CheckerInstance{

    @Autowired
    private TppProductRepo prodRepo;
    @Override
    public void Check(InstanceRequestDto dto) {
        if (prodRepo.existsByNumber(dto.contractNumber())) {
            throw new BadReqEcxeption("Параметр ContractNumber № договора " + dto.contractNumber() + " уже существует");
        }
    }
}
