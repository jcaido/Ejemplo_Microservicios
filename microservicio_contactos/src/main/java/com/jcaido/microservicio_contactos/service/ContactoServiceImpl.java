package com.jcaido.microservicio_contactos.service;

import com.jcaido.microservicio_contactos.model.Contacto;
import com.jcaido.microservicio_contactos.repository.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactoServiceImpl implements ContactoService{

    @Autowired
    ContactoRepository contactoRepository;

    @Override
    public boolean agregarContacto(Contacto contacto) {
        if (contacto.getIdContacto() == null)  {
            contactoRepository.save(contacto);
            return true;
        }

        return false;
    }

    @Override
    public List<Contacto> recuperarContactos() {
        return contactoRepository.findAll();
    }

    @Override
    public Contacto buscarContacto(Integer idContacto) {
        return contactoRepository.findById(idContacto).orElseThrow();
    }

    @Override
    public boolean modificarContacto(Contacto contacto) {
        Optional<Contacto> contactoAActualizar = contactoRepository.findById(contacto.getIdContacto());

        if (!contactoAActualizar.isPresent()) return false;

        contactoAActualizar.orElseThrow().setEdad(contacto.getEdad());
        contactoAActualizar.orElseThrow().setEmail(contacto.getEmail());
        contactoAActualizar.orElseThrow().setNombre(contacto.getNombre());
        contactoRepository.save(contactoAActualizar.orElseThrow());
        return true;
    }
}
