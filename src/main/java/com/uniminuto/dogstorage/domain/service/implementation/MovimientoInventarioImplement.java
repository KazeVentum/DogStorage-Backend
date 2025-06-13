package com.uniminuto.dogstorage.domain.service.implementation;

import java.util.List;
import jakarta.persistence.EntityNotFoundException;
import com.uniminuto.dogstorage.domain.repository.MovimientoInventarioRepository;
import com.uniminuto.dogstorage.domain.service.interfaces.MovimientoInventarioInterface;
import com.uniminuto.dogstorage.persistence.entity.MovimientoInventario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MovimientoInventarioImplement implements MovimientoInventarioInterface {
    private final MovimientoInventarioRepository movimientoInventarioRepository;

    @Autowired
    public MovimientoInventarioImplement(MovimientoInventarioRepository movimientoInventarioRepository) {
        this.movimientoInventarioRepository = movimientoInventarioRepository;
    }

    @Override
    public List<MovimientoInventario> getAll() {
        return movimientoInventarioRepository.findAll();
    }

    @Override
    public ResponseEntity<MovimientoInventario> getById(Integer id) {
        try {
            MovimientoInventario movimiento = movimientoInventarioRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("No se encontró el movimiento con el id: " + id));
            return ResponseEntity.ok(movimiento);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("El id debe ser un número entero");
        }
    }

    @Override
    public ResponseEntity<MovimientoInventario> save(MovimientoInventario movimientoInventario) {
        movimientoInventarioRepository.save(movimientoInventario);
        return ResponseEntity.ok(movimientoInventario);
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {
        if (movimientoInventarioRepository.existsById(id)) {
            movimientoInventarioRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<MovimientoInventario> update(Integer id, MovimientoInventario movimientoInventario) {
        try {
            MovimientoInventario movimientoExistente = movimientoInventarioRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("MovimientoInventario no encontrado para actualizar"));
            movimientoExistente.setTipoMovimiento(movimientoInventario.getTipoMovimiento());
            movimientoExistente.setProducto(movimientoInventario.getProducto());
            movimientoExistente.setUbicacionOrigen(movimientoInventario.getUbicacionOrigen());
            movimientoExistente.setUbicacionDestino(movimientoInventario.getUbicacionDestino());
            movimientoExistente.setCantidadBultos(movimientoInventario.getCantidadBultos());
            movimientoExistente.setPrecioUnitario(movimientoInventario.getPrecioUnitario());
            movimientoExistente.setTotal(movimientoInventario.getTotal());
            movimientoExistente.setMotivo(movimientoInventario.getMotivo());
            movimientoExistente.setNumeroFactura(movimientoInventario.getNumeroFactura());
            movimientoExistente.setProveedor(movimientoInventario.getProveedor());
            movimientoExistente.setFechaMovimiento(movimientoInventario.getFechaMovimiento());
            movimientoExistente.setUsuarioResponsable(movimientoInventario.getUsuarioResponsable());
            movimientoExistente.setObservaciones(movimientoInventario.getObservaciones());
            movimientoInventarioRepository.save(movimientoExistente);
            return ResponseEntity.ok(movimientoExistente);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("El id debe ser un número entero");
        }
    }
} 