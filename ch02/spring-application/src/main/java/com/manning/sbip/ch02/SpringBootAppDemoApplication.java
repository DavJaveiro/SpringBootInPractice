package com.manning.sbip.ch02;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootAppDemoApplication {

	public static void main(String[] args) {
		
		Properties properties = new Properties();
        // se um arquivo de configuração especificado não for encontrado, o Spring Boot não lançara uma exceção;
		properties.setProperty("spring.config.on-not-found", "ignore");
		
		SpringApplication application = new SpringApplication(SpringBootAppDemoApplication.class);
		application.setDefaultProperties(properties);
		application.run(args);
	}
}
