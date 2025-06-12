package com.uniminuto.dogstorage.domain.repository;

import com.uniminuto.dogstorage.persistence.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Integer> {
    Marca findByNombreMarca(String nombreMarca);
} 