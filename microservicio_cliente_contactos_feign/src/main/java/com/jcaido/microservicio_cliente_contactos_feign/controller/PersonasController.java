package com.jcaido.microservicio_cliente_contactos_feign.controller;

import com.jcaido.microservicio_cliente_contactos_feign.config.PersonasFeign;
import com.jcaido.microservicio_cliente_contactos_feign.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.standard.Media;
import java.util.List;

@RestController
public class PersonasController {

    @Autowired
    PersonasFeign personasFeign;

    @PostMapping(value = "personas/{nombre}/{email}/{edad}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Persona> altaPersonas(
            @PathVariable String nombre,
            @PathVariable String email,
            @PathVariable Integer edad) {
        Persona persona = new Persona(nombre, email, edad);
        personasFeign.altaPersona(persona);

        return personasFeign.getPersonas();
    }

    @GetMapping(value = "personas", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Persona> recuperarPersonas() {
        return personasFeign.getPersonas();
    }
}
