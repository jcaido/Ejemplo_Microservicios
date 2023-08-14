package com.jcaido.microservicio_contactos.controller;

import com.jcaido.microservicio_contactos.model.Contacto;
import com.jcaido.microservicio_contactos.service.ContactoService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContactoController {

    @Autowired
    ContactoService contactoService;

    @PostMapping(value = "contactos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public String guardarContacto(@RequestBody Contacto contacto) {
        return String.valueOf(contactoService.agregarContacto(contacto));
    }

    @GetMapping(value = "contactos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Contacto> obtenerTodosLosContactos() {
        return contactoService.recuperarContactos();
    }
}
