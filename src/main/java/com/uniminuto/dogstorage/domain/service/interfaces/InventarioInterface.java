package com.uniminuto.dogstorage.domain.service.interfaces;

import java.util.List;
import com.uniminuto.dogstorage.persistence.entity.Inventario;
import org.springframework.http.ResponseEntity;

public interface InventarioInterface {
    List<Inventario> getAll();
    ResponseEntity<Inventario> getById(Integer id);
    ResponseEntity<Inventario> save(Inventario inventario);
    ResponseEntity<Void> delete(Integer id);
    ResponseEntity<Inventario> update(Integer id, Inventario inventario);
} 