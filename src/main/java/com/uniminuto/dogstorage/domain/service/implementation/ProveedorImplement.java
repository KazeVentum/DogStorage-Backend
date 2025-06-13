package com.uniminuto.dogstorage.domain.service.implementation;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityNotFoundException;

import com.uniminuto.dogstorage.domain.repository.ProveedorRepository;
import com.uniminuto.dogstorage.domain.service.interfaces.ProveedorInterface;
import com.uniminuto.dogstorage.persistence.entity.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProveedorImplement implements ProveedorInterface {

    private final ProveedorRepository proveedorRepository;

    @Autowired
    public ProveedorImplement(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    @Override
    public List<Proveedor> getAll() {
        return proveedorRepository.findAll();
    }

    @Override
    public ResponseEntity<Proveedor> getById(Integer id) {
        try {
            Proveedor proveedor = proveedorRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("No se encontro el proveedor con el id: " + id));
            return ResponseEntity.ok(proveedor);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("El id debe ser un numero entero");
        }
    }

    @Override
    public ResponseEntity<Proveedor> save(Proveedor proveedor) {
        proveedorRepository.save(proveedor);
        return ResponseEntity.ok(proveedor);
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {
        if (proveedorRepository.existsById(id)) {
            proveedorRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Proveedor> update(Integer id, Proveedor proveedor) {
        try {
            Proveedor proveedorOptional = proveedorRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Proveedor No encontraado para actualizar"));
            proveedorOptional.setNombreProveedor(proveedor.getNombreProveedor());
            proveedorOptional.setContacto(proveedor.getContacto());
            proveedorOptional.setTelefono(proveedor.getTelefono());
            proveedorOptional.setEmail(proveedor.getEmail());
            proveedorOptional.setDireccion(proveedor.getDireccion());
            proveedorRepository.save(proveedorOptional);
            return ResponseEntity.ok(proveedorOptional);
        }catch (NumberFormatException e) {
            throw new NumberFormatException("El id debe ser un numero entero");
        }
    }
}
