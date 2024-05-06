package com.controlecliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.controlecliente.infra.CustomJpaRepositoryImpl;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomJpaRepositoryImpl.class)
public class ControleClienteApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControleClienteApiApplication.class, args);
	}

}
