package com.uniminuto.dogstorage.api.controller;

import java.util.List;
import com.uniminuto.dogstorage.domain.service.implementation.RazaImplement;
import com.uniminuto.dogstorage.persistence.entity.Raza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/raza")
public class RazaController {
    private final RazaImplement razaImplement;

    @Autowired
    public RazaController(RazaImplement razaImplement) {
        this.razaImplement = razaImplement;
    }

    @GetMapping("/getAll")
    public List<Raza> getAllRazas() {
        return razaImplement.getAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Raza> getRazaById(@PathVariable Integer id) {
        return razaImplement.getById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<Raza> saveRaza(@RequestBody Raza raza) {
        return razaImplement.save(raza);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRaza(@PathVariable Integer id) {
        return razaImplement.delete(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Raza> updateRaza(@PathVariable Integer id, @RequestBody Raza raza) {
        return razaImplement.update(id, raza);
    }
} 