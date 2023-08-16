package com.jcaido.microservicio_cliente_contactos.controller;

import com.jcaido.microservicio_cliente_contactos.model.Persona;
import com.jcaido.microservicio_cliente_contactos.service.AccesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@RestController
public class PersonaController {

    @Autowired
    RestTemplate template;

    @Autowired
    AccesoService accesoService;

    String url = "http://localhost:8080";

    @GetMapping(value = "persona/{nombre}/{email}/{edad}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Persona> altaPersona(
            @PathVariable("nombre") String nombre,
            @PathVariable("email") String email,
            @PathVariable("edad") Integer edad) throws InterruptedException, ExecutionException {

        Persona persona = new Persona(nombre, email, edad);
        CompletableFuture<List<Persona>> resultado = accesoService.llamadaServicio(persona);

        for (int i=1;i<50;i++) {
            System.out.println("esperando");
            Thread.sleep(50);
        }

        return resultado.get();
    }

    @GetMapping(value = "personas/{edad1}/{edad2}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Persona> obtenerPersonasPorEdades(
            @PathVariable("edad1") Integer edad1,
            @PathVariable("edad2") Integer edad2) {

        Persona[] personas = template.getForObject(url + "/contactos", Persona[].class);
        return Arrays.stream(personas)
                .filter(persona->persona.getEdad() >= edad1 && persona.getEdad()<= edad2)
                .collect(Collectors.toList());
    }
}
