package br.com.factorcity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@EnableSpringDataWebSupport
@SpringBootApplication
public class FactorCityApplication {

	public static void main(String[] args) {
		SpringApplication.run(FactorCityApplication.class, args);
	}

}
