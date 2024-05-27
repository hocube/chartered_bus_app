package com.bus.chartered_bus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.annotation.Validated;

@SpringBootApplication
@Validated
public class CharteredBusApplication {

	public static void main(String[] args) {
		SpringApplication.run(CharteredBusApplication.class, args);
	}

}
