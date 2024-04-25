package ru.rest.L5.Check;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.rest.L5.dto.InstanceRequestDto;
import ru.rest.L5.exceptions.NotFoundException;
import ru.rest.L5.repository.TppProductRepo;

@Service
@Qualifier("Step_2_1")
public class Step_2_1 implements  CheckerInstance {
    @Autowired
    private TppProductRepo prodRepo;
    @Override
    public void Check(InstanceRequestDto dto) {
        if (!prodRepo.existsById(dto.instanceId())) {
            throw new NotFoundException("Экземпляр продукта с параметром instanceId " + dto.instanceId() + " не найден");
        }
    }
}
