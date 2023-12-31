package com.jcaido.microservicio_contactos.service;

import com.jcaido.microservicio_contactos.model.Contacto;

import java.util.List;

public interface ContactoService {

    boolean agregarContacto(Contacto contacto);
    List<Contacto> recuperarContactos() throws InterruptedException;
    Contacto buscarContacto(Integer idContacto);
    boolean modificarContacto(Contacto contacto);
    boolean eliminarContacto(String email);
}
