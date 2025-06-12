package com.uniminuto.dogstorage.api.controller;

import java.util.List;

import com.uniminuto.dogstorage.domain.service.implementation.ProveedorImplement;
import com.uniminuto.dogstorage.persistence.entity.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {
    private final ProveedorImplement proveedorImplement;

    @Autowired
    public ProveedorController(ProveedorImplement proveedorImplement) {
        this.proveedorImplement = proveedorImplement;
    }

    @GetMapping("/getAll")
    public List<Proveedor> getAllProveedores(){
        return proveedorImplement.getAll();
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Proveedor> getProveedorById(@PathVariable Integer id){
        return proveedorImplement.getById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<Proveedor> saveProveedor(@RequestBody Proveedor proveedor){
        return proveedorImplement.save(proveedor);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteProveedor(@PathVariable Integer id){
        return proveedorImplement.delete(id);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Proveedor> updateProveedor(@PathVariable Integer id, @RequestBody Proveedor proveedor){
        return proveedorImplement.update(id, proveedor);
    }
}
