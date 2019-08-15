package com.adverum.vagnernegreiros.cursos.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableConfigurationProperties
@EnableJpaRepositories("com.adverum.vagnernegreiros.cursos.repository")
@EnableTransactionManagement
@EntityScan(basePackages = {"com.adverum.vagnernegreiros.cursos.model"}) 
@ComponentScan("com.adverum.vagnernegreiros.cursos.controller")
public class CursosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursosApplication.class, args);
	}

}
