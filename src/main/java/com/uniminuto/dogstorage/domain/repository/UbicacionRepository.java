package com.uniminuto.dogstorage.domain.repository;

import com.uniminuto.dogstorage.persistence.entity.Ubicacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UbicacionRepository extends JpaRepository<Ubicacion, Integer> {
    Ubicacion findByNombreUbicacion(String nombreUbicacion);
}
