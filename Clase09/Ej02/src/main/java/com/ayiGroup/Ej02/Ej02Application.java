package com.ayiGroup.Ej02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ej02Application {

	private static final Logger logger = LoggerFactory.getLogger(Ej02Application.class);


	public static void main(String[] args) {

		SpringApplication.run(Ej02Application.class, args);

		logger.info("Iniciando aplicación!");

	}

}
