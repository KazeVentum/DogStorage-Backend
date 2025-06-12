package com.uniminuto.dogstorage.domain.service.implementation;

import java.util.List;
import javax.persistence.EntityNotFoundException;
import com.uniminuto.dogstorage.domain.repository.RazaRepository;
import com.uniminuto.dogstorage.domain.service.interfaces.RazaInterface;
import com.uniminuto.dogstorage.persistence.entity.Raza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RazaImplement implements RazaInterface {
    private final RazaRepository razaRepository;

    @Autowired
    public RazaImplement(RazaRepository razaRepository) {
        this.razaRepository = razaRepository;
    }

    @Override
    public List<Raza> getAll() {
        return razaRepository.findAll();
    }

    @Override
    public ResponseEntity<Raza> getById(Integer id) {
        try {
            Raza raza = razaRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("No se encontró la raza con el id: " + id));
            return ResponseEntity.ok(raza);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("El id debe ser un número entero");
        }
    }

    @Override
    public ResponseEntity<Raza> save(Raza raza) {
        razaRepository.save(raza);
        return ResponseEntity.ok(raza);
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {
        if (razaRepository.existsById(id)) {
            razaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Raza> update(Integer id, Raza raza) {
        try {
            Raza razaExistente = razaRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Raza no encontrada para actualizar"));
            razaExistente.setNombreRaza(raza.getNombreRaza());
            razaExistente.setTamano(raza.getTamano());
            razaRepository.save(razaExistente);
            return ResponseEntity.ok(razaExistente);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("El id debe ser un número entero");
        }
    }
} 