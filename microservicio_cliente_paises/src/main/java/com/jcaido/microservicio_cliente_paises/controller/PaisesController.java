package com.jcaido.microservicio_cliente_paises.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jcaido.microservicio_cliente_paises.model.Pais;
import com.jcaido.microservicio_cliente_paises.service.PaisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaisesController {

    @Autowired
    PaisesService paisesService;

    @GetMapping(value = "paises", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Pais> obtenerPaises() throws JsonProcessingException {
        return paisesService.obtenerPaises();
    }

    @GetMapping(value = "paises/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Pais> buscarPaises(@PathVariable("name") String name) throws JsonProcessingException {
        return paisesService.buscarPaises(name);
    }
}
