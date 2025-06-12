package com.uniminuto.dogstorage.domain.service.interfaces;

import java.util.List;
import com.uniminuto.dogstorage.persistence.entity.Raza;
import org.springframework.http.ResponseEntity;

public interface RazaInterface {
    List<Raza> getAll();
    ResponseEntity<Raza> getById(Integer id);
    ResponseEntity<Raza> save(Raza raza);
    ResponseEntity<Void> delete(Integer id);
    ResponseEntity<Raza> update(Integer id, Raza raza);
} 