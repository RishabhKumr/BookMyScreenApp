package com.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.user.filter.AuthTokenFilter;

@SpringBootApplication
public class UserMicroserviceApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(UserMicroserviceApplication.class, args);
	}


	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
}
