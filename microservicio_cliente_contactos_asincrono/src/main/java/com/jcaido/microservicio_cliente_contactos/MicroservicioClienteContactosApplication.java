package com.jcaido.microservicio_cliente_contactos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Executor;

@SpringBootApplication
@EnableAsync
public class MicroservicioClienteContactosApplication {

	public static void main(String[] args) {

		SpringApplication.run(MicroservicioClienteContactosApplication.class, args);
	}

	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}

	@Bean
	public Executor executor() {
		return new ThreadPoolTaskExecutor();
	}

}
