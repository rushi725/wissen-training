package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.service.TxrService;

@SpringBootApplication
@EntityScan("com.example.model")
@EnableJpaRepositories(basePackages = { "com.example.repository" })
@ComponentScan(basePackages = { "com.example.service", "com.example.repository" ,"com.example.web"})
public class AccountServiceBootApplication {
	
	
	

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceBootApplication.class, args);

	}

}
