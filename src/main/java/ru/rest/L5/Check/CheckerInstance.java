package ru.rest.L5.Check;

import ru.rest.L5.dto.InstanceRequestDto;
import ru.rest.L5.dto.TppProductRegisterRequestDto;

public interface CheckerInstance {
    //public <T> void Check ( T dto);
    public void Check(InstanceRequestDto dto);
}
