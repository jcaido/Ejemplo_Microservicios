package com.jcaido.microservicio_cliente_contactos.service;

import com.jcaido.microservicio_cliente_contactos.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class AccesoServiceImpl implements AccesoService {

    @Autowired
    RestTemplate template;

    String url = "http://localhost:8080";

    @Async
    public CompletableFuture<List<Persona>> llamadaServicio(Persona persona) {
        template.postForLocation(url + "/contactos", persona);
        Persona[] personas = template.getForObject(url + "/contactos", Persona[].class);

        return CompletableFuture.completedFuture(Arrays.asList(personas));
    }
}
