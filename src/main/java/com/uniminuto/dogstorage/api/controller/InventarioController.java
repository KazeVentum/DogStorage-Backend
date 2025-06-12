package com.uniminuto.dogstorage.api.controller;

import java.util.List;
import com.uniminuto.dogstorage.domain.service.implementation.InventarioImplement;
import com.uniminuto.dogstorage.persistence.entity.Inventario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventario")
public class InventarioController {
    private final InventarioImplement inventarioImplement;

    @Autowired
    public InventarioController(InventarioImplement inventarioImplement) {
        this.inventarioImplement = inventarioImplement;
    }

    @GetMapping("/getAll")
    public List<Inventario> getAllInventarios() {
        return inventarioImplement.getAll();
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Inventario> getInventarioById(@PathVariable Integer id) {
        return inventarioImplement.getById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<Inventario> saveInventario(@RequestBody Inventario inventario) {
        return inventarioImplement.save(inventario);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteInventario(@PathVariable Integer id) {
        return inventarioImplement.delete(id);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Inventario> updateInventario(@PathVariable Integer id, @RequestBody Inventario inventario) {
        return inventarioImplement.update(id, inventario);
    }
} 