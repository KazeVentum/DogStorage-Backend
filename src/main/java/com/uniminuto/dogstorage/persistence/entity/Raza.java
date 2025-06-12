package com.uniminuto.dogstorage.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "razas")
@Data
public class Raza implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_raza")
    private Integer razaId;

    @Column(name = "nombre_raza", nullable = false, length = 100)
    private String nombreRaza;

    @Enumerated(EnumType.STRING)
    @Column(name = "tamaño")
    private TamanoRaza tamano;

    @Column(name = "activo")
    private final Boolean activo = true;

    @OneToMany(mappedBy = "raza", cascade = CascadeType.ALL, orphanRemoval = true)
    private java.util.List<Producto> productos;

    public enum TamanoRaza {
        pequeño, mediano, grande, gigante
    }
}