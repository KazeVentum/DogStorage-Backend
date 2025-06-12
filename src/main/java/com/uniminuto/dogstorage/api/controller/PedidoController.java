package com.uniminuto.dogstorage.api.controller;

import java.util.List;
import com.uniminuto.dogstorage.domain.service.implementation.PedidoImplement;
import com.uniminuto.dogstorage.persistence.entity.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    private final PedidoImplement pedidoImplement;

    @Autowired
    public PedidoController(PedidoImplement pedidoImplement) {
        this.pedidoImplement = pedidoImplement;
    }

    @GetMapping("/getAll")
    public List<Pedido> getAllPedidos() {
        return pedidoImplement.getAll();
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable Integer id) {
        return pedidoImplement.getById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<Pedido> savePedido(@RequestBody Pedido pedido) {
        return pedidoImplement.save(pedido);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable Integer id) {
        return pedidoImplement.delete(id);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Pedido> updatePedido(@PathVariable Integer id, @RequestBody Pedido pedido) {
        return pedidoImplement.update(id, pedido);
    }
} 