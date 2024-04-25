package ru.rest.L5.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.rest.L5.Check.CheckerInstance;
import ru.rest.L5.dto.*;
import ru.rest.L5.entity.Agreement;
import ru.rest.L5.entity.TppProduct;
import ru.rest.L5.entity.TppRefProductRegisterType;
import ru.rest.L5.enums.ProdType;
import ru.rest.L5.exceptions.BadReqEcxeption;
import ru.rest.L5.exceptions.NotFoundException;
import ru.rest.L5.repository.AgreementRepo;
import ru.rest.L5.repository.TppProductRepo;
import ru.rest.L5.repository.TppRefProductRegisterTypeRepo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Validated
@Transactional
public class InatanceServiceImpl implements  InstanceService{

    //Контроли
    private CheckerInstance step1;
    private CheckerInstance step1_1;
    private CheckerInstance step1_2;
    private CheckerInstance step2_1;

    //Репозитории

    @Autowired
    private TppRefProductRegisterTypeRepo regRepo;

    @Autowired
    private TppProductRepo productRepo;

    @Autowired
    private AgreementRepo agrRepo;

    //Сервис
    @Autowired
    AccountService accserv;


    @Autowired
    InatanceServiceImpl(@Qualifier("Step_1Inst") CheckerInstance step1,
                        @Qualifier("Step_1_1") CheckerInstance step1_1,
                        @Qualifier("Step_1_2") CheckerInstance step1_2,
                        @Qualifier("Step_2_1") CheckerInstance step2_1)
    {this.step1 = step1;
    this.step1_1 = step1_1;
    this.step1_2 = step1_2;
    this.step2_1 = step2_1;}
    @Override
    public ResponseInstDto CreateInstance(InstanceRequestDto dto) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        ResponseInstDto resDto;

        //Step 1
        step1.Check(dto);

        if (dto.instanceId() == null) {
            //Step1_1. Создать новый экземпляр
            step1_1.Check(dto);
            step1_2.Check(dto);

            //Step1_3
            List<TppRefProductRegisterType> regList = regRepo.findAllByProductCode(dto.productCode());

            if (regList.isEmpty()) {
                throw new NotFoundException(" КодПродукта " + dto.productCode() + " не найдено в Каталоге продуктов");
            }
            else {//Step1_4, 1_5. Интересно почему мы не пишем по ТЗ agreement, хотя структура есть в JSON
                TppProduct newProd = new TppProduct();
                //Непонятно какой реквизит куда помещвть. Что нашла то нашла
                newProd.setProduct_code_id(dto.ReferenceCode());
                newProd.setPriority(dto.priority());
                newProd.setNumber(dto.contractNumber());
                newProd.setThreshold_amount(dto.thresholdAmount());
                newProd.setPriority(dto.priority());
                newProd.setTax_rate(dto.taxPercentageRate());
                newProd.setInterest_rate_type(dto.rateType());
                newProd.setType(ProdType.valueOf(dto.productType()).getDesc());
                try {
                    newProd.setStart_date_time(format.parse(dto.contractDate()));
                } catch (ParseException e) {
                    newProd.setStart_date_time(null);
                }

                TppProduct newProdRec = productRepo.save(newProd);

                //ПР
                TppProductRegisterRequestDto regdto = new TppProductRegisterRequestDto(newProdRec.getId(), dto.registerType(), null, dto.IsoCurrencyCode(),
                        dto.BranchCode(), "00", dto.mdmCode(), null, null, null, null);
                ResponseDto resAccDto = accserv.CreateAccount(regdto);

                //Формируем ответ
                resDto = new ResponseInstDto(new InstanceId( newProdRec.getId().toString(), new ArrayList<>(List.of(resAccDto.data().accountId().toString())), new ArrayList<>(List.of(""))));

            }

        }
        else
        {
            List<String> listId = new ArrayList<>();
            //Step2_1.Изменить состав ДС
            step2_1.Check(dto);
            step1_2.Check(dto); //Судя по ТЗ контроль в шагах 1_2 и 2_2 один и тот же
            //Добавляем по массиву
            dto.instanceArrangement().forEach((arrDto)->{
                Agreement agr = new Agreement();
                agr.setProduct_id(dto.instanceId());  //Ранее ыыяснили, что такой продукт есть, раз до этого места добрались
                agr.setNumber(arrDto.Number());
                agr.setCoefficient(arrDto.coefficient());
                try {
                    agr.setCancel_date(format.parse(arrDto.CancelDate()));
                } catch (ParseException|RuntimeException e) {
                    agr.setCancel_date(null);
                }
                try {
                    agr.setClosing_date(format.parse(arrDto.closingDate()));
                } catch (ParseException|RuntimeException e) {
                    agr.setClosing_date(null);
                }
                try {
                    agr.setOpening_date(format.parse(arrDto.openingDate()));
                } catch (ParseException|RuntimeException e) {
                    agr.setOpening_date(null);
                }
               try {
                    agr.setInterest_calculation_date(format.parse(arrDto.interestCalculationDate()));
                } catch (ParseException|RuntimeException e) {
                    agr.setInterest_calculation_date(null);
                }
                agr.setArrangement_type(arrDto.arrangementType());
                agr.setCancellation_reason(arrDto.cancellationReason());
                agr.setCoefficient_action(arrDto.coefficientAction());
                agr.setGeneral_agreement_id(arrDto.GeneralAgreementId());
                agr.setInterest_rate(arrDto.interestRate());
                agr.setMaximal_interest_rate(arrDto.maximalnterestRate());
                agr.setMaximal_interest_rate_coefficient(arrDto.maximalnterestRateCoefficient());
                agr.setMaximal_interest_rate_coefficient_action(arrDto.minimumInterestRateCoefficientAction());
                agr.setMinimum_interest_rate(arrDto.minimumInterestRate());
                agr.setMinimum_interest_rate_coefficient(arrDto.minimumInterestRateCoefficient());
                agr.setMaximal_interest_rate_coefficient_action(arrDto.minimumInterestRateCoefficientAction());
                agr.setSheduler_job_id(arrDto.shedulerJobId());

                Agreement newRec = agrRepo.save(agr);
                listId.add(newRec.getId().toString());

            });

            resDto = new ResponseInstDto(new InstanceId( dto.instanceId().toString(), new ArrayList<>(List.of("")), listId));

        }
        //ResponseInstDto resDto = new ResponseInstDto(new InstanceId( "45", new ArrayList<>(List.of("34","43")), new ArrayList<>(List.of("45"))));
        return resDto;
    }
}
