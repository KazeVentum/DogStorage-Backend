package com.uniminuto.dogstorage.domain.service.interfaces;

import java.util.List;

import com.uniminuto.dogstorage.persistence.entity.Proveedor;
import org.springframework.http.ResponseEntity;

public interface ProveedorInterface  {
    List<Proveedor> getAll();
    ResponseEntity<Proveedor> getById(Integer id);
    ResponseEntity<Proveedor> save(Proveedor proveedor);
    ResponseEntity<Void> delete(Integer id);
    ResponseEntity<Proveedor> update(Integer id, Proveedor proveedor);
}
