package ru.rest.L5.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rest.L5.dto.*;
import ru.rest.L5.service.AccountService;
import ru.rest.L5.service.InstanceService;

import java.util.ArrayList;
import java.util.List;

@RestController
//То что указано на классе, конкатенируется с тем сто на методе, получаем итоговый запрос
@RequestMapping("/")
public class AccountRest {

    @Autowired
    AccountService accserv;

    @Autowired
    InstanceService instserv;

    @Autowired
    AccountRest(AccountService accserv, InstanceService instserv)
    {this.accserv = accserv;
    this.instserv = instserv;};

@GetMapping("corporate-settlement-account/create/{id}")
    public ResponseEntity<TppProductRegisterDto> GetAccount(@PathVariable Integer id){

    //var понимает что пришло в данный момент. Доступ к полям через get().
    var temp = accserv.GetById(id);
    TppProductRegisterDto dto = new TppProductRegisterDto(temp.get().getId(), temp.get().getType(), temp.get().getProductId(), temp.get().getAccount(), temp.get().getCurrency_code(), temp.get().getState(), temp.get().getAccount_number());
    return new ResponseEntity<TppProductRegisterDto>(dto, HttpStatus.OK);
}

//Т.к. входящий и возвращаемый запросы различаются, будут разные dto
@PostMapping("corporate-settlement-account/create")
    public ResponseEntity<ResponseDto> CreateAccount(@RequestBody TppProductRegisterRequestDto dto){

    ResponseDto resDto = accserv.CreateAccount(dto);

    return new ResponseEntity<>(resDto, HttpStatus.CREATED);
    }

    @PostMapping("corporate-settlement-instance/create")
    public ResponseEntity<ResponseInstDto>  CreateInstance(@RequestBody InstanceRequestDto dto){

        ResponseInstDto resDto = instserv.CreateInstance(dto);

        return new ResponseEntity<>(resDto, HttpStatus.CREATED);
    }
}
