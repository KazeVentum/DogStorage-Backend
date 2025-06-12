package com.uniminuto.dogstorage.domain.service.interfaces;

import java.util.List;
import com.uniminuto.dogstorage.persistence.entity.Producto;
import org.springframework.http.ResponseEntity;

public interface ProductoInterface {
    List<Producto> getAll();
    ResponseEntity<Producto> getById(Integer id);
    ResponseEntity<Producto> save(Producto producto);
    ResponseEntity<Void> delete(Integer id);
    ResponseEntity<Producto> update(Integer id, Producto producto);
} 