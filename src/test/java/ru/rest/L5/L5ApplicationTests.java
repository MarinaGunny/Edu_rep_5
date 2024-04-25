package ru.rest.L5;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import ru.rest.L5.dto.*;
import ru.rest.L5.exceptions.BadReqEcxeption;
import ru.rest.L5.exceptions.NotFoundException;
import ru.rest.L5.service.AccountService;
import ru.rest.L5.service.InstanceService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@Testcontainers
class L5ApplicationTests {

    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15-alpine")
            .withDatabaseName("testdb")
            .withUsername("postgres")
            .withPassword("postgres")
			/*.withCopyFileToContainer(MountableFile.forHostPath("schema.sql"),
                "/docker-entrypoint-initdb.d/"
			)*/;


    @BeforeAll
    static void beforeAll(ApplicationContext context) {
        postgres.start();
    }

    @AfterAll
    static void afterAll() {
        postgres.stop();
    }

    //Свойства не зашиваются в application.properties, а берутся из контейнера
    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.name", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    //Контекст будет пустой пока не напишем то что выше
    @Test
    void contextLoads(ApplicationContext context) {
        Assertions.assertNotNull(context);
    }

    //Пример как можно
    @Test
    void pgContainerIsUp() {
        Assertions.assertEquals("running", postgres.getContainerInfo().getState().getStatus());
    }

    @Test
    void createAccountTest(@Autowired AccountService srv) {

        //Сервис подтянулся
        Assertions.assertNotNull(srv);

        TppProductRegisterRequestDto inputDto = new TppProductRegisterRequestDto(null, "03.012.002_47533_ComSoLd",
                "Клиентский", "800", "0022", "00", "15", null, null, null, null);

        TppProductRegisterRequestDto input2Dto = new TppProductRegisterRequestDto(999, "03.012.002_47533_ComSoLd5555555",
                "Клиентский", "800", "0022", "00", "15", null, null, null, null);

        TppProductRegisterRequestDto inputGoodDto = new TppProductRegisterRequestDto(999, "03.012.002_47533_ComSoLd",
                "Клиентский", "800", "0022", "00", "15", null, null, null, null);

        //Проверка контролей. Из сервиса делаем Executable, заворачивая в лямбду
        Assertions.assertThrows(BadReqEcxeption.class, () -> {
            srv.CreateAccount(inputDto);
        });

        Assertions.assertThrows(NotFoundException.class, () -> {
            srv.CreateAccount(input2Dto);
        });

        //Создание регистра

        ResponseDto dto = srv.CreateAccount(inputGoodDto);

        Assertions.assertNotNull(dto.data().accountId());
    }

    @Test
    void createInstanceTest(@Autowired InstanceService srv) {
        //Сервис подтянулся
        Assertions.assertNotNull(srv);

        InstanceRequestDto inputDto = new InstanceRequestDto(null, null, null, null, null, null,
                null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, new ArrayList<>());
        InstanceRequestDto inputGoodDto = new InstanceRequestDto(null, "NSO", "03.012.002", "03.012.002_47533_ComSoLd", "15", "48-TR",
                "2024-04-11", 0, null, null, BigDecimal.valueOf(0), null, null, null,
                null, null, "0022", "800", null, null,
                new ArrayList<>(List.of(new InstanceArrangement(null,null, null, null, "64",
                        null, null, null, null, null, null, null, null,
                        null, null, null, null, null, null,
                        null, null))));


        //Проверка контролей. Из сервиса делаем Executable, заворачивая в лямбду
        Assertions.assertThrows(BadReqEcxeption.class, () -> {
            srv.CreateInstance(inputDto);
        });

        //Создание продукта

        ResponseInstDto dto = srv.CreateInstance(inputGoodDto);

        Assertions.assertNotNull(dto.data().instanceId());
    }

}
