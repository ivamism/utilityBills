package com.ivam.utilityBills;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class UtilityBillsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(UtilityBillsApplication.class, args);
	}

}
