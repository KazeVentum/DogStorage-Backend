package com.uniminuto.dogstorage.domain.service.implementation;

import java.util.List;

import jakarta.persistence.EntityNotFoundException;

import com.uniminuto.dogstorage.domain.repository.UbicacionRepository;
import com.uniminuto.dogstorage.domain.service.interfaces.UbicacionInterface;
import com.uniminuto.dogstorage.persistence.entity.Ubicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UbicacionImplement implements UbicacionInterface {

    private final UbicacionRepository ubicacionRepository;

    @Autowired
    public UbicacionImplement(UbicacionRepository ubicacionRepository) {
        this.ubicacionRepository = ubicacionRepository;
    }

    @Override
    public List<Ubicacion> getAll() {
        return ubicacionRepository.findAll();
    }

    @Override
    public ResponseEntity<Ubicacion> getById(Integer id) {
        try {
            Ubicacion ubicacion = ubicacionRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("No se encontró la ubicación con el id: " + id));
            return ResponseEntity.ok(ubicacion);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("El id debe ser un número entero");
        }
    }

    @Override
    public ResponseEntity<Ubicacion> save(Ubicacion ubicacion) {
        ubicacionRepository.save(ubicacion);
        return ResponseEntity.ok(ubicacion);
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {
        if (ubicacionRepository.existsById(id)) {
            ubicacionRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Ubicacion> update(Integer id, Ubicacion ubicacion) {
        try {
            Ubicacion ubicacionExistente = ubicacionRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Ubicación no encontrada para actualizar"));
            ubicacionExistente.setNombreUbicacion(ubicacion.getNombreUbicacion());
            ubicacionExistente.setTipoUbicacion(ubicacion.getTipoUbicacion());
            ubicacionExistente.setDireccion(ubicacion.getDireccion());
            ubicacionExistente.setTelefono(ubicacion.getTelefono());
            ubicacionExistente.setResponsable(ubicacion.getResponsable());
            ubicacionRepository.save(ubicacionExistente);
            return ResponseEntity.ok(ubicacionExistente);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("El id debe ser un número entero");
        }
    }
}
