package com.uniminuto.dogstorage.api.controller;

import java.util.List;

import com.uniminuto.dogstorage.domain.service.implementation.UbicacionImplement;
import com.uniminuto.dogstorage.persistence.entity.Ubicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ubicacion")
public class UbicacionController {
    private final UbicacionImplement ubicacionImplement;

    @Autowired
    public UbicacionController(UbicacionImplement ubicacionImplement) {
        this.ubicacionImplement = ubicacionImplement;
    }

    @GetMapping("/getAll")
    public List<Ubicacion> getAllUbicaciones() {
        return ubicacionImplement.getAll();
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Ubicacion> getUbicacionById(@PathVariable Integer id) {
        return ubicacionImplement.getById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<Ubicacion> saveUbicacion(@RequestBody Ubicacion ubicacion) {
        return ubicacionImplement.save(ubicacion);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteUbicacion(@PathVariable Integer id) {
        return ubicacionImplement.delete(id);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Ubicacion> updateUbicacion(@PathVariable Integer id, @RequestBody Ubicacion ubicacion) {
        return ubicacionImplement.update(id, ubicacion);
    }
}
