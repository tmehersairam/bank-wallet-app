package com.fis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "All apis for bank wallet app", version = "1.0", description = "Users Api End Points"))
public class BankWalletAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankWalletAppApplication.class, args);
	}

}
