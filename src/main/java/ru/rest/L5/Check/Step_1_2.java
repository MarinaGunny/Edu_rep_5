package ru.rest.L5.Check;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.rest.L5.dto.InstanceArrangement;
import ru.rest.L5.dto.InstanceRequestDto;
import ru.rest.L5.exceptions.BadReqEcxeption;
import ru.rest.L5.repository.AgreementRepo;

@Service
@Qualifier("Step_1_2")
public class Step_1_2  implements  CheckerInstance{

    @Autowired
    private AgreementRepo agrRepo;

    @Override
    public void Check(InstanceRequestDto dto) {
        dto.instanceArrangement().forEach((InstanceArrangement ie) -> {
            if (agrRepo.existsByNumber(ie.Number())) {
                throw new BadReqEcxeption("Параметр № Дополнительного соглашения (сделки) Number " + ie.Number() + " уже существует");
            }
        });

    }
}
