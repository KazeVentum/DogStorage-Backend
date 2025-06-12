package com.uniminuto.dogstorage.domain.service.implementation;

import java.util.List;
import javax.persistence.EntityNotFoundException;
import com.uniminuto.dogstorage.domain.repository.InventarioRepository;
import com.uniminuto.dogstorage.domain.service.interfaces.InventarioInterface;
import com.uniminuto.dogstorage.persistence.entity.Inventario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class InventarioImplement implements InventarioInterface {
    private final InventarioRepository inventarioRepository;

    @Autowired
    public InventarioImplement(InventarioRepository inventarioRepository) {
        this.inventarioRepository = inventarioRepository;
    }

    @Override
    public List<Inventario> getAll() {
        return inventarioRepository.findAll();
    }

    @Override
    public ResponseEntity<Inventario> getById(Integer id) {
        try {
            Inventario inventario = inventarioRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("No se encontró el inventario con el id: " + id));
            return ResponseEntity.ok(inventario);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("El id debe ser un número entero");
        }
    }

    @Override
    public ResponseEntity<Inventario> save(Inventario inventario) {
        inventarioRepository.save(inventario);
        return ResponseEntity.ok(inventario);
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {
        if (inventarioRepository.existsById(id)) {
            inventarioRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Inventario> update(Integer id, Inventario inventario) {
        try {
            Inventario inventarioExistente = inventarioRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Inventario no encontrado para actualizar"));
            inventarioExistente.setProducto(inventario.getProducto());
            inventarioExistente.setUbicacion(inventario.getUbicacion());
            inventarioExistente.setCantidadBultos(inventario.getCantidadBultos());
            inventarioExistente.setFechaActualizacion(inventario.getFechaActualizacion());
            inventarioRepository.save(inventarioExistente);
            return ResponseEntity.ok(inventarioExistente);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("El id debe ser un número entero");
        }
    }
} 