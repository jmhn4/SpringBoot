package com.basic;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookBootApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(BookBootApplication.class);
		application.setWebApplicationType(WebApplicationType.SERVLET);
		application.run(args);
	}


	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;
	}

}
