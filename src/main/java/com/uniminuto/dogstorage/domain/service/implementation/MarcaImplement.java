package com.uniminuto.dogstorage.domain.service.implementation;

import java.util.List;
import jakarta.persistence.EntityNotFoundException;
import com.uniminuto.dogstorage.domain.repository.MarcaRepository;
import com.uniminuto.dogstorage.domain.service.interfaces.MarcaInterface;
import com.uniminuto.dogstorage.persistence.entity.Marca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MarcaImplement implements MarcaInterface {
    private final MarcaRepository marcaRepository;

    @Autowired
    public MarcaImplement(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    @Override
    public List<Marca> getAll() {
        return marcaRepository.findAll();
    }

    @Override
    public ResponseEntity<Marca> getById(Integer id) {
        try {
            Marca marca = marcaRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("No se encontró la marca con el id: " + id));
            return ResponseEntity.ok(marca);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("El id debe ser un número entero");
        }
    }

    @Override
    public ResponseEntity<Marca> save(Marca marca) {
        marcaRepository.save(marca);
        return ResponseEntity.ok(marca);
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {
        if (marcaRepository.existsById(id)) {
            marcaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Marca> update(Integer id, Marca marca) {
        try {
            Marca marcaExistente = marcaRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Marca no encontrada para actualizar"));
            marcaExistente.setNombreMarca(marca.getNombreMarca());
            marcaExistente.setDescripcion(marca.getDescripcion());
            marcaRepository.save(marcaExistente);
            return ResponseEntity.ok(marcaExistente);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("El id debe ser un número entero");
        }
    }
} 