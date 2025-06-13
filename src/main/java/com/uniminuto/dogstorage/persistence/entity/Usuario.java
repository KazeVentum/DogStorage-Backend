package com.uniminuto.dogstorage.persistence.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 *
 * @author lmora
 */
/**
 * Entidad que representa la tabla "usuarios" en la base de datos.
 */
@Data
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Identificador único del usuario.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;

    /**
     * Nombre del usuario.
     */
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    /**
     * Correo electrónico del usuario (debe ser único).
     */
    @Column(name = "correo", nullable = false, length = 100, unique = true)
    private String correo;

    /**
     * Número de teléfono del usuario (opcional).
     */
    @Column(name = "telefono", length = 20)
    private String telefono;

    /**
     * Fecha de registro del usuario (se asigna automáticamente).
     */
    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;
    
    /**
     * Estado del usuario Activo/Inactivo.
     */
    @Column(name = "activo")
    private Boolean activo;
}
