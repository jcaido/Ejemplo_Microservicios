package com.jcaido.microservicio_contactos.service;

import com.jcaido.microservicio_contactos.model.Contacto;
import com.jcaido.microservicio_contactos.repository.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactoServiceImpl implements ContactoService{

    @Autowired
    ContactoRepository contactoRepository;

    @Override
    public void agregarContacto(Contacto contacto) {
        contactoRepository.save(contacto);
    }
}
