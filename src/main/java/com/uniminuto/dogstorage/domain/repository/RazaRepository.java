package com.uniminuto.dogstorage.domain.repository;

import com.uniminuto.dogstorage.persistence.entity.Raza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RazaRepository extends JpaRepository<Raza, Integer> {
    Raza findByNombreRaza(String nombreRaza);
} 