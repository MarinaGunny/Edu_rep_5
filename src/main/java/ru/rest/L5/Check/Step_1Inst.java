package ru.rest.L5.Check;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.rest.L5.dto.InstanceRequestDto;
import ru.rest.L5.exceptions.BadReqEcxeption;

@Service
@Qualifier("Step_1Inst")
public class Step_1Inst implements  CheckerInstance{

    @Override
    public void Check(InstanceRequestDto dto) {
        String errStr = "";

        if (dto.productType() == null) {
            errStr += " productType, ";
        }

        if (dto.productCode() == null) {
            errStr += "productCode, ";
        }

        if (dto.registerType() == null) {
            errStr += "registerType, ";
        }

        if (dto.mdmCode() == null) {
            errStr += "mdmCode, ";
        }

        if (dto.contractNumber() == null) {
            errStr += "contractNumber, ";
        }

        if (dto.contractDate() == null) {
            errStr += "contractDate, ";
        }

        if (dto.priority() == null) {
            errStr += "priority";
        }

        if (errStr != "") {
            throw new BadReqEcxeption("Имя обязательного параметра " + errStr + " не заполнено");
        }
    }
}

