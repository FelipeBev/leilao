package br.com.alura.leilao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.AbstractEnvironment;

@SpringBootApplication
public class LeilaoApplication {

	public static void main(String[] args) {

		System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "prod");
		SpringApplication.run(LeilaoApplication.class, args);
	}

}
