package com.uniminuto.dogstorage.domain.service.implementation;

import java.util.List;
import jakarta.persistence.EntityNotFoundException;
import com.uniminuto.dogstorage.domain.repository.PedidoRepository;
import com.uniminuto.dogstorage.domain.service.interfaces.PedidoInterface;
import com.uniminuto.dogstorage.persistence.entity.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PedidoImplement implements PedidoInterface {
    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoImplement(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public List<Pedido> getAll() {
        return pedidoRepository.findAll();
    }

    @Override
    public ResponseEntity<Pedido> getById(Integer id) {
        try {
            Pedido pedido = pedidoRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("No se encontró el pedido con el id: " + id));
            return ResponseEntity.ok(pedido);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("El id debe ser un número entero");
        }
    }

    @Override
    public ResponseEntity<Pedido> save(Pedido pedido) {
        pedidoRepository.save(pedido);
        return ResponseEntity.ok(pedido);
    }

    @Override
    public ResponseEntity<Void> delete(Integer id) {
        if (pedidoRepository.existsById(id)) {
            pedidoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Pedido> update(Integer id, Pedido pedido) {
        try {
            Pedido pedidoExistente = pedidoRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Pedido no encontrado para actualizar"));
            pedidoExistente.setNumeroPedido(pedido.getNumeroPedido());
            pedidoExistente.setProveedor(pedido.getProveedor());
            pedidoExistente.setFechaPedido(pedido.getFechaPedido());
            pedidoExistente.setFechaEntregaEsperada(pedido.getFechaEntregaEsperada());
            pedidoExistente.setFechaEntregaReal(pedido.getFechaEntregaReal());
            pedidoExistente.setEstado(pedido.getEstado());
            pedidoExistente.setSubtotal(pedido.getSubtotal());
            pedidoExistente.setImpuestos(pedido.getImpuestos());
            pedidoExistente.setTotal(pedido.getTotal());
            pedidoExistente.setObservaciones(pedido.getObservaciones());
            pedidoRepository.save(pedidoExistente);
            return ResponseEntity.ok(pedidoExistente);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("El id debe ser un número entero");
        }
    }
} 