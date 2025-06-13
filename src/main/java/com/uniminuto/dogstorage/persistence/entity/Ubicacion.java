package com.uniminuto.dogstorage.persistence.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

import jakarta.persistence.*;

@Entity
@Table(name = "ubicaciones")
@Data
public class Ubicacion implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ubicacion")
    private Integer ubicacionId;

    @Column(name = "nombre_ubicacion", nullable = false, length = 100)
    private String nombreUbicacion;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_ubicacion", nullable = false)
    private TipoUbicacion tipoUbicacion;

    @Column(name = "direccion", length = 200)
    private String direccion;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @Column(name = "responsable", length = 100)
    private String responsable;

    @Column(name = "activo")
    private final Boolean activo = true;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @OneToMany(mappedBy = "ubicacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private java.util.List<Inventario> inventarios;

    @OneToMany(mappedBy = "ubicacionOrigen", cascade = CascadeType.ALL, orphanRemoval = true)
    private java.util.List<MovimientoInventario> movimientosOrigen;

    @OneToMany(mappedBy = "ubicacionDestino", cascade = CascadeType.ALL, orphanRemoval = true)
    private java.util.List<MovimientoInventario> movimientosDestino;

    public enum TipoUbicacion {
        almacen_central, sede, proveedor
    }
}