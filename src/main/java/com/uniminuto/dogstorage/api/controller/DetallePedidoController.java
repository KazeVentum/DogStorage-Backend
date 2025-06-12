package com.uniminuto.dogstorage.api.controller;

import java.util.List;
import com.uniminuto.dogstorage.domain.service.implementation.DetallePedidoImplement;
import com.uniminuto.dogstorage.persistence.entity.DetallePedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/detalle-pedido")
public class DetallePedidoController {
    private final DetallePedidoImplement detallePedidoImplement;

    @Autowired
    public DetallePedidoController(DetallePedidoImplement detallePedidoImplement) {
        this.detallePedidoImplement = detallePedidoImplement;
    }

    @GetMapping("/getAll")
    public List<DetallePedido> getAllDetalles() {
        return detallePedidoImplement.getAll();
    }

    @GetMapping("get/{id}")
    public ResponseEntity<DetallePedido> getDetalleById(@PathVariable Integer id) {
        return detallePedidoImplement.getById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<DetallePedido> saveDetalle(@RequestBody DetallePedido detallePedido) {
        return detallePedidoImplement.save(detallePedido);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteDetalle(@PathVariable Integer id) {
        return detallePedidoImplement.delete(id);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<DetallePedido> updateDetalle(@PathVariable Integer id, @RequestBody DetallePedido detallePedido) {
        return detallePedidoImplement.update(id, detallePedido);
    }
} 