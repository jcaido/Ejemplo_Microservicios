package com.jcaido.microservicio_cliente_contactos.service;

import com.jcaido.microservicio_cliente_contactos.model.Persona;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface AccesoService {

    CompletableFuture<List<Persona>> llamadaServicio(Persona persona);
}
