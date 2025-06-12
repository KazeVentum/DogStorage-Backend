package com.uniminuto.dogstorage.domain.service.implementation;

import java.util.List;
import javax.persistence.EntityNotFoundException;
import com.uniminuto.dogstorage.domain.repository.DetallePedidoRepository;
import com.uniminuto.dogstorage.domain.service.interfaces.DetallePedidoInterface;
import com.uniminuto.dogstorage.persistence.entity.DetallePedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DetallePedidoImplement implements DetallePedidoInterface {
    private final DetallePedidoRepository detallePedidoRepository;

    @Autowired
    public DetallePedidoImplement(DetallePedidoRepository detallePedidoRepository) {
        this.detallePedidoRepository = detallePedidoRepository;
    }

    @Override
    public List<DetallePedido> getAll() {
        return detallePedidoRepository.findAll();
    }

    @Override
    public ResponseEntity<DetallePedido> getById(Integer id) {
        try {
            DetallePedido detalle = detallePedidoRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("No se encontró el detalle con el id: " + id));
            return ResponseEntity.ok(detalle);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("El id debe ser un número entero");
        }
    }

    @Override
    public ResponseEntity<DetallePedido> save(DetallePedido detallePedido) {
        detallePedidoRepository.save(detallePedido);
        return ResponseEntity.ok(detallePedido);
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {
        if (detallePedidoRepository.existsById(id)) {
            detallePedidoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<DetallePedido> update(Integer id, DetallePedido detallePedido) {
        try {
            DetallePedido detalleExistente = detallePedidoRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("DetallePedido no encontrado para actualizar"));
            detalleExistente.setPedido(detallePedido.getPedido());
            detalleExistente.setProducto(detallePedido.getProducto());
            detalleExistente.setCantidadSolicitada(detallePedido.getCantidadSolicitada());
            detalleExistente.setCantidadRecibida(detallePedido.getCantidadRecibida());
            detalleExistente.setPrecioUnitario(detallePedido.getPrecioUnitario());
            detalleExistente.setSubtotal(detallePedido.getSubtotal());
            detallePedidoRepository.save(detalleExistente);
            return ResponseEntity.ok(detalleExistente);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("El id debe ser un número entero");
        }
    }
} 