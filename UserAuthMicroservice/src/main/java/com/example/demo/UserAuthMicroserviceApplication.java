package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Filter.JWTFilter;

@SpringBootApplication
public class UserAuthMicroserviceApplication {
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public FilterRegistrationBean jwtFilterBean()
	{
	FilterRegistrationBean fb = new FilterRegistrationBean();
	fb.setFilter(new JWTFilter());
	fb.addUrlPatterns("/api/v1/*");
	return fb;

	}

	public static void main(String[] args) {
		SpringApplication.run(UserAuthMicroserviceApplication.class, args);
	}
}
