package ru.rest.L5.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.rest.L5.Check.CheckerAccount;
import ru.rest.L5.dto.AccountId;
import ru.rest.L5.dto.ResponseDto;
import ru.rest.L5.dto.TppProductRegisterRequestDto;
import ru.rest.L5.entity.Account;
import ru.rest.L5.entity.AccountPool;
import ru.rest.L5.entity.TppProductRegister;
import ru.rest.L5.enums.AccStatus;
import ru.rest.L5.exceptions.BadReqEcxeption;
import ru.rest.L5.exceptions.NotFoundException;
import ru.rest.L5.repository.AccountPoolRepo;
import ru.rest.L5.repository.TppProductRegisterRepo;
import ru.rest.L5.repository.TppRefProductRegisterTypeRepo;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Validated
public class AccountServiceImpl implements AccountService {

    //Контроли
    private CheckerAccount step1;
    private CheckerAccount step2;
    private CheckerAccount step3;

    //Репозитории
    @Autowired
    private TppProductRegisterRepo repo;

    @Autowired
    private TppRefProductRegisterTypeRepo typerepo;

    @Autowired
    private AccountPoolRepo accrepo;

    @Autowired
    public AccountServiceImpl(@Qualifier("Step_1") CheckerAccount step1,
                              @Qualifier("Step_2") CheckerAccount step2,
                              @Qualifier("Step_3") CheckerAccount step3) {
        this.step1 = step1;
        this.step2 = step2;
        this.step3 = step3;
    }

    @Override
    public Optional<TppProductRegister> GetById(Integer Id) {
        //findById уже возвращает Optional в отличие от deprecated GetById
        //return  Optional.of(new TppProductRegister(0, "type",987,11111,"978","OPEN","77777"));//Optional.empty();
        return repo.findById(Id);
    }

    @Override
    public ResponseDto CreateAccount(TppProductRegisterRequestDto dto) {

        TppProductRegister tprod = new TppProductRegister();
        tprod.setProductId(dto.instanceId());
        //Пустой instance
        tprod.setCurrency_code(dto.currencyCode());
        //Пустой instance
        step1.Check(dto);
        step2.Check(dto);
        // Наличие value в tpp_ref_product_register_type
        step3.Check(dto);
        //Вообще если мы выше не вылетели по исключению, наверное можно из файла сразу вписать
        tprod.setType(typerepo.findByValue(dto.registryTypeCode()).getValue());
        tprod.setState(AccStatus.OPEN.getDesc());

        AccountPool pool = accrepo.findPool(dto.branchCode(), dto.currencyCode(), dto.mdmCode(), dto.priorityCode(), dto.registryTypeCode());

        if (pool == null) {throw new NotFoundException("Не найден подходящий пул счетов");}

        List<Account> listacc = pool.getAccounts().stream().toList();

        tprod.setAccount_number(listacc.get(0).getAccount_number());
        tprod.setAccount(listacc.get(0).getId());


        TppProductRegister newrec = repo.save(tprod);


        ResponseDto resDto = new ResponseDto(new AccountId(newrec.getId().toString()));

        return resDto;
    }
}
