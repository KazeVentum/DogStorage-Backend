package com.uniminuto.dogstorage.api.controller;

import java.util.List;
import com.uniminuto.dogstorage.domain.service.implementation.MovimientoInventarioImplement;
import com.uniminuto.dogstorage.persistence.entity.MovimientoInventario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movimiento-inventario")
public class MovimientoInventarioController {
    private final MovimientoInventarioImplement movimientoInventarioImplement;

    @Autowired
    public MovimientoInventarioController(MovimientoInventarioImplement movimientoInventarioImplement) {
        this.movimientoInventarioImplement = movimientoInventarioImplement;
    }

    @GetMapping("/getAll")
    public List<MovimientoInventario> getAllMovimientos() {
        return movimientoInventarioImplement.getAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<MovimientoInventario> getMovimientoById(@PathVariable Integer id) {
        return movimientoInventarioImplement.getById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<MovimientoInventario> saveMovimiento(@RequestBody MovimientoInventario movimientoInventario) {
        return movimientoInventarioImplement.save(movimientoInventario);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMovimiento(@PathVariable Integer id) {
        return movimientoInventarioImplement.delete(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MovimientoInventario> updateMovimiento(@PathVariable Integer id, @RequestBody MovimientoInventario movimientoInventario) {
        return movimientoInventarioImplement.update(id, movimientoInventario);
    }
} 