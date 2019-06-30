package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.example.demo.model")
@EnableJpaRepositories(basePackages = { "com.example.demo.repository" })
@SpringBootApplication
public class TodoAppBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoAppBootApplication.class, args);
	}

}
