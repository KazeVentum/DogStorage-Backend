package com.uniminuto.dogstorage.domain.service.implementation;

import java.util.List;
import jakarta.persistence.EntityNotFoundException;
import com.uniminuto.dogstorage.domain.repository.ProductoRepository;
import com.uniminuto.dogstorage.domain.service.interfaces.ProductoInterface;
import com.uniminuto.dogstorage.persistence.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductoImplement implements ProductoInterface {
    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoImplement(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> getAll() {
        return productoRepository.findAll();
    }

    @Override
    public ResponseEntity<Producto> getById(Integer id) {
        try {
            Producto producto = productoRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("No se encontró el producto con el id: " + id));
            return ResponseEntity.ok(producto);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("El id debe ser un número entero");
        }
    }

    @Override
    public ResponseEntity<Producto> save(Producto producto) {
        productoRepository.save(producto);
        return ResponseEntity.ok(producto);
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Producto> update(Integer id, Producto producto) {
        try {
            Producto productoExistente = productoRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado para actualizar"));
            productoExistente.setNombreProducto(producto.getNombreProducto());
            productoExistente.setMarca(producto.getMarca());
            productoExistente.setPesoKg(producto.getPesoKg());
            productoExistente.setRaza(producto.getRaza());
            productoExistente.setEdadPerro(producto.getEdadPerro());
            productoExistente.setPrecioCompra(producto.getPrecioCompra());
            productoExistente.setPrecioVenta(producto.getPrecioVenta());
            productoExistente.setDescripcion(producto.getDescripcion());
            productoRepository.save(productoExistente);
            return ResponseEntity.ok(productoExistente);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("El id debe ser un número entero");
        }
    }
} 