package com.sbcash.gabryel.processo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableJpaRepositories("com.sbcash.gabryel.processo.repository.jpa")
@EnableReactiveMongoRepositories("com.sbcash.gabryel.processo.repository.nosql")
public class ProcessoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProcessoApplication.class, args);
	}

}
