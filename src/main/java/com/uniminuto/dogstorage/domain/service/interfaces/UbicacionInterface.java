package com.uniminuto.dogstorage.domain.service.interfaces;

import java.util.List;

import com.uniminuto.dogstorage.persistence.entity.Ubicacion;
import org.springframework.http.ResponseEntity;

public interface UbicacionInterface {
    List<Ubicacion> getAll();
    ResponseEntity<Ubicacion> getById(Integer id);
    ResponseEntity<Ubicacion> save(Ubicacion ubicacion);
    ResponseEntity<Void> delete(Integer id);
    ResponseEntity<Ubicacion> update(Integer id, Ubicacion ubicacion);
}
