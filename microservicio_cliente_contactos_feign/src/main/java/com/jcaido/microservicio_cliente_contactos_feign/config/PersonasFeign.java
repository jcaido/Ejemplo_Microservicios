package com.jcaido.microservicio_cliente_contactos_feign.config;

import com.jcaido.microservicio_cliente_contactos_feign.model.Persona;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "servicio-contactos")
public interface PersonasFeign {

    @GetMapping(value = "contactos", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Persona> getPersona();

    @PostMapping(value = "contactos", consumes = MediaType.APPLICATION_JSON_VALUE)
    void altaPersona(@RequestBody Persona persona);
}
