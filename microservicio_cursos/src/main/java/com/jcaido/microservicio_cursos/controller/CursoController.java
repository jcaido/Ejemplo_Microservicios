package com.jcaido.microservicio_cursos.controller;

import com.jcaido.microservicio_cursos.model.Curso;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CursoController {

    @GetMapping(value = "curso", produces = MediaType.APPLICATION_JSON_VALUE)
    public Curso getCurso() {
        return new Curso("Java", 20, "mañana");
    }
}
