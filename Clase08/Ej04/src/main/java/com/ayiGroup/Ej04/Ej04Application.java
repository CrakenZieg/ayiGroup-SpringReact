package com.ayiGroup.Ej04;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ej04Application {

	private static final Logger logger = LoggerFactory.getLogger(Ej04Application.class);

	public static void main(String[] args) {

		SpringApplication.run(Ej04Application.class, args);

		logger.info("Iniciando aplicación!");
	}

}
