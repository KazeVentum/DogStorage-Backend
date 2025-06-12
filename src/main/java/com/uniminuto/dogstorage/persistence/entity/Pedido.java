package com.uniminuto.dogstorage.persistence.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "pedidos")
@Data
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Integer pedidoId;

    @Column(name = "numero_pedido", unique = true, length = 50)
    private String numeroPedido;

    @ManyToOne
    @JoinColumn(name = "id_proveedor", nullable = false)
    private Proveedor proveedor;

    @Column(name = "fecha_pedido", nullable = false)
    private LocalDate fechaPedido;

    @Column(name = "fecha_entrega_esperada")
    private LocalDate fechaEntregaEsperada;

    @Column(name = "fecha_entrega_real")
    private LocalDate fechaEntregaReal;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private final EstadoPedido estado = EstadoPedido.pendiente;

    @Column(name = "subtotal", precision = 12, scale = 2)
    private BigDecimal subtotal;

    @Column(name = "impuestos", precision = 10, scale = 2)
    private BigDecimal impuestos;

    @Column(name = "total", precision = 12, scale = 2)
    private BigDecimal total;

    @Column(name = "observaciones", columnDefinition = "TEXT")
    private String observaciones;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    public enum EstadoPedido {
        pendiente, confirmado, en_transito, entregado, cancelado
    }
}