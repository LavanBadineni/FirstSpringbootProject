package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@ComponentScan(basePackages = "com")
public class FirstspringbootApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(FirstspringbootApplication.class);
		
		/*
		 * SpringApplication application = new
		 * SpringApplication(FirstspringbootApplication.class);
		 * 
		 * ConfigurableApplicationContext context = application.run(args);
		 * ConfigurableEnvironment environment = context.getEnvironment();
		 * environment.setActiveProfiles("dev");
		 * application.run(FirstspringbootApplication.class, args);
		 */
		
		
	}

}
