package com.uniminuto.dogstorage.domain.repository;

import com.uniminuto.dogstorage.persistence.entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedorRepository extends JpaRepository <Proveedor, Integer>{
    Proveedor findByNombreProveedor(String nombreProveedor);
}
