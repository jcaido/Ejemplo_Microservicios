package com.jcaido.microservicio_cliente_paises;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MicroservicioClientePaisesApplication {

	public static void main(String[] args) {

		SpringApplication.run(MicroservicioClientePaisesApplication.class, args);
	}

	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}

}
