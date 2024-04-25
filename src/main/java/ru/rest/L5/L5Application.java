package ru.rest.L5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.rest.L5.entity.AccountPool;
import ru.rest.L5.entity.Agreement;
import ru.rest.L5.entity.TppProduct;
import ru.rest.L5.entity.TppProductRegister;
import ru.rest.L5.enums.ProdType;
import ru.rest.L5.repository.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@SpringBootApplication(scanBasePackages = "ru.rest.L5")
@EntityScan(basePackages = "ru.rest.L5.entity")
@EnableJpaRepositories(basePackages = "ru.rest.L5.repository")
public class L5Application {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(L5Application.class, args);
//		AccountPoolRepo repo = ctx.getBean(AccountPoolRepo.class);
//		AccountPool acc = repo.findPool("0022", "800", "15", "00", "03.012.002_47533_ComSoLd");
//		System.out.println(acc.getAccounts().stream().toList().get(0));
//		System.out.println("repo created  " + repo);
//		Account_pool ap = new Account_pool("99", "840", "16", "40817_cc");
//		HashSet<Account> acc = new HashSet<>();
//		acc.add(new Account("40817810000822556", ap));
//		acc.add(new Account("408178400008225588888", ap));
//		ap.setAccounts(acc);
//		repo.save(ap);


		//TppProductRepo repo = ctx.getBean(TppProductRepo.class);
//		System.out.println("repo created  " + repo);
		//TppProduct tp = new TppProduct();
		//tp.setProduct_code_id(2345);
		//tp.setNso(BigDecimal.valueOf(79.9));
		//tp.setClient_id(45678);
		//HashSet<Agreement> agr = new HashSet<>();
		//agr.add(new Agreement("rr-5678", "3456yy"));
		//tp.setAgrees(agr);
		//repo.save(tp);

//		TppRefAccountTypeRepo repo = ctx.getBean(TppRefAccountTypeRepo.class);
//		System.out.println(repo.findAll().toString());

//		TppRefProductClassRepo repo = ctx.getBean(TppRefProductClassRepo.class);
//		System.out.println(repo.findAll().toString());

		//TppProductRegisterRepo repo = ctx.getBean(TppProductRegisterRepo.class);
//		TppProductRegister pr = new TppProductRegister();
//		pr.setType("03.012.002_47533_ComSoLd");
//		pr.setProduct_id(4567);
//		pr.setAccount_number("43555555");
//		repo.save(pr);
//		System.out.println(repo.findAll().toString());
		//List<TppProductRegister> list = repo.findAllByProductId(569);
		//list.forEach(System.out::println);

		//TppRefProductRegisterTypeRepo repo = ctx.getBean(TppRefProductRegisterTypeRepo.class);
		//System.out.println(repo.findAllByProductCode("03.012.002"));
//		System.out.println(repo.findByValue("03.012.002_47533_ComSoLd").getInternal_id());
//		System.out.println(repo.existsByValue("03.012.002_47533_ComSoLd"));

		//System.out.println(ProdType.valueOf("NSO").getDesc());

	}

}
