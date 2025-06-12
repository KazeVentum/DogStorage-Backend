package com.uniminuto.dogstorage.api.controller;

import java.util.List;
import com.uniminuto.dogstorage.domain.service.implementation.ProductoImplement;
import com.uniminuto.dogstorage.persistence.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    private final ProductoImplement productoImplement;

    @Autowired
    public ProductoController(ProductoImplement productoImplement) {
        this.productoImplement = productoImplement;
    }

    @GetMapping("/getAll")
    public List<Producto> getAllProductos() {
        return productoImplement.getAll();
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable Integer id) {
        return productoImplement.getById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<Producto> saveProducto(@RequestBody Producto producto) {
        return productoImplement.save(producto);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Integer id) {
        return productoImplement.delete(id);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable Integer id, @RequestBody Producto producto) {
        return productoImplement.update(id, producto);
    }
} 