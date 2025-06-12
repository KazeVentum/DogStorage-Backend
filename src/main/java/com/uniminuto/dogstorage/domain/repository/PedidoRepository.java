package com.uniminuto.dogstorage.domain.repository;

import com.uniminuto.dogstorage.persistence.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
} 