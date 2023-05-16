package com.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@SpringBootApplication
public class MovieHandlerMicroserviceApplication {

	
	
	public static void main(String[] args) {
		SpringApplication.run(MovieHandlerMicroserviceApplication.class, args);
	}
	
}
