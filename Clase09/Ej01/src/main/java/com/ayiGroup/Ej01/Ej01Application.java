package com.ayiGroup.Ej01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ej01Application {

	private static final Logger logger = LoggerFactory.getLogger(Ej01Application.class);

	public static void main(String[] args) {

		SpringApplication.run(Ej01Application.class, args);

		logger.info("Iniciando aplicación!");

	}

}
