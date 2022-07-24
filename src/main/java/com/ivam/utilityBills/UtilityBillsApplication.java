package com.ivam.utilityBills;

import com.ivam.utilityBills.model.Family;
import com.ivam.utilityBills.repository.FamilyRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class UtilityBillsApplication {

	public static void main(String[] args) {
//		ConfigurableApplicationContext context =
		SpringApplication.run(UtilityBillsApplication.class, args);

//		FamilyRepository familyRepository = context.getBean(FamilyRepository.class);
//		TariffsRepository tariffsRepository = context.getBean(TariffsRepository.class);


//		familyRepository.save(new Family("Дом вцелом"));
//		familyRepository.save(new Family("Семья Мочаловых"));
//		Tariffs gas = new Tariffs("Gas", 0.541_7);
//
//		tariffsRepository.save(gas);
//		tariffsRepository.save(new Tariffs("Electricity", 0.1977));
//		System.out.println(tariffsRepository.findAll());
//		System.out.println(familyRepository.findAll());

	}

}