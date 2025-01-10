package com.Sathish.Ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class EcommerceApplication extends SpringBootServletInitializer {

	// This method is for WAR deployment configuration
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(EcommerceApplication.class); // Correct class name here
	}

	// Main method to start the Spring Boot application
	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}
}
