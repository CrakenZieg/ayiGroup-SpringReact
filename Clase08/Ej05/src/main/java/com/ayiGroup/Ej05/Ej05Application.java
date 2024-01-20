package com.ayiGroup.Ej05;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ej05Application {

	private static final Logger logger = LoggerFactory.getLogger(Ej05Application.class);

	public static void main(String[] args) {

		SpringApplication.run(Ej05Application.class, args);

		logger.info("Iniciando aplicación!");
	}

}
