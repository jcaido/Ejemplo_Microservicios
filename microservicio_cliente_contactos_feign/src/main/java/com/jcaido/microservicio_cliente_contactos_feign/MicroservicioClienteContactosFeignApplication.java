package com.jcaido.microservicio_cliente_contactos_feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroservicioClienteContactosFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioClienteContactosFeignApplication.class, args);
	}

}
