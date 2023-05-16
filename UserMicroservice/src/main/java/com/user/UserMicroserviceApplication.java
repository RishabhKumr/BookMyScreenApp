package com.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.user.filter.AuthTokenFilter;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@SpringBootApplication
public class UserMicroserviceApplication {
	@Bean
	public FilterRegistrationBean jwtFilterBean()
	{
		FilterRegistrationBean fb = new FilterRegistrationBean();
		fb.setFilter(new AuthTokenFilter());
		fb.addUrlPatterns("/api/test/*");
		return fb;
		
	}
	
	@Configuration
	class OpenApiConfig
	{
		
		@Bean
		public OpenAPI customconfig()
		{
			final String securitySchemeName = "bearerAuth";

return new OpenAPI().addSecurityItem(new SecurityRequirement()
				.addList(securitySchemeName)).components(new Components().addSecuritySchemes(securitySchemeName, new SecurityScheme()
						.name(securitySchemeName).type(SecurityScheme.Type.HTTP).scheme("Bearer ")
						.bearerFormat("JWT")));
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(UserMicroserviceApplication.class, args);
	}


	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
}
