package com.tjcichra.tira;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
// @EnableJpaRepositories
public class TiraApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiraApplication.class, args);
	}

}
