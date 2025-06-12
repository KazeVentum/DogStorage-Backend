package com.uniminuto.dogstorage.domain.service.interfaces;

import java.util.List;
import com.uniminuto.dogstorage.persistence.entity.Pedido;
import org.springframework.http.ResponseEntity;

public interface PedidoInterface {
    List<Pedido> getAll();
    ResponseEntity<Pedido> getById(Integer id);
    ResponseEntity<Pedido> save(Pedido pedido);
    ResponseEntity<Void> delete(Integer id);
    ResponseEntity<Pedido> update(Integer id, Pedido pedido);
} 