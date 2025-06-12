package com.uniminuto.dogstorage.domain.service.interfaces;

import java.util.List;
import com.uniminuto.dogstorage.persistence.entity.DetallePedido;
import org.springframework.http.ResponseEntity;

public interface DetallePedidoInterface {
    List<DetallePedido> getAll();
    ResponseEntity<DetallePedido> getById(Integer id);
    ResponseEntity<DetallePedido> save(DetallePedido detallePedido);
    ResponseEntity<Void> delete(Integer id);
    ResponseEntity<DetallePedido> update(Integer id, DetallePedido detallePedido);
} 