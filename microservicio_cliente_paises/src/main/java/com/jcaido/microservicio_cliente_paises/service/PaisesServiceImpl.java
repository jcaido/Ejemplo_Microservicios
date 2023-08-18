package com.jcaido.microservicio_cliente_paises.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.jcaido.microservicio_cliente_paises.model.Pais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaisesServiceImpl implements PaisesService{

    String url = "https://restcountries.com/v3.1/all";

    @Autowired
    RestTemplate template;

    @Override
    public List<Pais> obtenerPaises() throws JsonProcessingException {

        String resultado = template.getForObject(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        List<Pais> paises = new ArrayList<>();
        ArrayNode array = (ArrayNode) mapper.readTree(resultado);
        for (Object ob:array) {
            ObjectNode json = (ObjectNode) ob;
            paises.add(new Pais(
                    json.get("name)").asText(),
                    json.get("capital").asText(),
                    json.get("population").asInt(),
                    json.get("flag").asText()
                    )
            );
        };

        return paises;
    }

    @Override
    public List<Pais> buscarPaises(String name) throws JsonProcessingException {

        return obtenerPaises().stream()
                .filter(pais -> pais.getNombre().contains(name))
                .collect(Collectors.toList());
    }
}
