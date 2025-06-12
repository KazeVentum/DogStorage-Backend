package com.uniminuto.dogstorage.domain.repository;

import com.uniminuto.dogstorage.persistence.entity.MovimientoInventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoInventarioRepository extends JpaRepository<MovimientoInventario, Integer> {
} 