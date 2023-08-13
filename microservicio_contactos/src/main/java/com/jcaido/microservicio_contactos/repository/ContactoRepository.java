package com.jcaido.microservicio_contactos.repository;

import com.jcaido.microservicio_contactos.model.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ContactoRepository extends JpaRepository<Contacto, Integer> {

    Contacto findByEmail(String email);

    @Transactional
    @Modifying
    @Query("Delete from Contacto c Where c.email=?1")
    void eliminarContactoPorEmail(String email);
}
