package com.uniminuto.dogstorage.domain.service.interfaces;

import java.util.List;
import com.uniminuto.dogstorage.persistence.entity.MovimientoInventario;
import org.springframework.http.ResponseEntity;

public interface MovimientoInventarioInterface {
    List<MovimientoInventario> getAll();
    ResponseEntity<MovimientoInventario> getById(Integer id);
    ResponseEntity<MovimientoInventario> save(MovimientoInventario movimientoInventario);
    ResponseEntity<Void> delete(Integer id);
    ResponseEntity<MovimientoInventario> update(Integer id, MovimientoInventario movimientoInventario);
} 