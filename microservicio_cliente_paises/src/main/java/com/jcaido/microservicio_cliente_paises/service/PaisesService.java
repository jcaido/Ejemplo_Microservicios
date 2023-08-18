package com.jcaido.microservicio_cliente_paises.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jcaido.microservicio_cliente_paises.model.Pais;

import java.util.List;

public interface PaisesService {
    List<Pais> obtenerPaises() throws JsonProcessingException;
    List<Pais> buscarPaises(String name) throws JsonProcessingException;
}
