package com.uniminuto.dogstorage.domain.service.interfaces;

import java.util.List;
import com.uniminuto.dogstorage.persistence.entity.Marca;
import org.springframework.http.ResponseEntity;

public interface MarcaInterface {
    List<Marca> getAll();
    ResponseEntity<Marca> getById(Integer id);
    ResponseEntity<Marca> save(Marca marca);
    ResponseEntity<Void> delete(Integer id);
    ResponseEntity<Marca> update(Integer id, Marca marca);
} 