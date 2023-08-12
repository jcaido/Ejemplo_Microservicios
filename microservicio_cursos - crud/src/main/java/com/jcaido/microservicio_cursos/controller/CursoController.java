package com.jcaido.microservicio_cursos.controller;

import com.jcaido.microservicio_cursos.model.Curso;
import jakarta.annotation.PostConstruct;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "cursos", produces = MediaType.APPLICATION_XML_VALUE)
    public List<Curso> cursos() {
        return cursos;
    }

    @GetMapping(value = "curso/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> buscarCurso(@PathVariable("name") String nombre) {
        List<Curso> aux = new ArrayList<>();
        for (Curso curso: cursos) {
            if (curso.getNombre().contains(nombre)) {
                aux.add(curso);
            }
        }

        return aux;
    }

    @DeleteMapping(value = "curso/{name}")
    public void eliminarCurso(@PathVariable("name") String nombre) {
        cursos.removeIf(curso -> curso.getNombre().equals(nombre));
    }

    @PostMapping(value = "curso", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> altaCurso(@RequestBody Curso curso) {
        cursos.add(curso);

        return cursos;
    }

    @PutMapping(value = "curso", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> modificaCurso(Curso curso) {
        for (int i = 0; i < cursos.size(); i++) {
            if (cursos.get(i).getNombre().equals(curso.getNombre())) {
                cursos.set(i, curso);
            }
        }

        return cursos;
    }

}
