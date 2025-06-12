package com.uniminuto.dogstorage.api.controller;

import java.util.List;
import com.uniminuto.dogstorage.domain.service.implementation.MarcaImplement;
import com.uniminuto.dogstorage.persistence.entity.Marca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/marca")
public class MarcaController {
    private final MarcaImplement marcaImplement;

    @Autowired
    public MarcaController(MarcaImplement marcaImplement) {
        this.marcaImplement = marcaImplement;
    }

    @GetMapping("/getAll")
    public List<Marca> getAllMarcas() {
        return marcaImplement.getAll();
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Marca> getMarcaById(@PathVariable Integer id) {
        return marcaImplement.getById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<Marca> saveMarca(@RequestBody Marca marca) {
        return marcaImplement.save(marca);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteMarca(@PathVariable Integer id) {
        return marcaImplement.delete(id);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Marca> updateMarca(@PathVariable Integer id, @RequestBody Marca marca) {
        return marcaImplement.update(id, marca);
    }
} 