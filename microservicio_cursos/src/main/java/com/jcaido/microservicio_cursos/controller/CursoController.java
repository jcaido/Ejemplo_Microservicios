package com.jcaido.microservicio_cursos.controller;

import com.jcaido.microservicio_cursos.model.Curso;
import jakarta.annotation.PostConstruct;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CursoController {

    private List<Curso> cursos = new ArrayList<>();

    @PostConstruct
    public void init() {
        cursos.add(new Curso("Spring", 40, "mañana"));
        cursos.add(new Curso("Spring boot", 150, "tarde"));
        cursos.add(new Curso("Spring boot", 150, "tarde"));
        cursos.add(new Curso("PhP", 50, "tarde"));
        cursos.add(new Curso("Node.js", 15, "mañana"));

    }

    @GetMapping(value = "curso", produces = MediaType.APPLICATION_JSON_VALUE)
    public Curso getCurso() {
        return new Curso("Java", 20, "mañana");
    }

    @GetMapping(value = "cursos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> cursos() {
        return cursos;
    }
}
