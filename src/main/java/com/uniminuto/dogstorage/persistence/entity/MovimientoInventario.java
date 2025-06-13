package com.uniminuto.dogstorage.persistence.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "movimientos_inventario")
@Data
public class MovimientoInventario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimiento")
    private Integer movimientoId;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_movimiento", nullable = false)
    private TipoMovimiento tipoMovimiento;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_ubicacion_origen")
    private Ubicacion ubicacionOrigen;

    @ManyToOne
    @JoinColumn(name = "id_ubicacion_destino")
    private Ubicacion ubicacionDestino;

    @Column(name = "cantidad_bultos", nullable = false)
    private Integer cantidadBultos;

    @Column(name = "precio_unitario", precision = 10, scale = 2)
    private BigDecimal precioUnitario;

    @Column(name = "total", precision = 12, scale = 2)
    private BigDecimal total;

    @Column(name = "motivo", length = 200)
    private String motivo;

    @Column(name = "numero_factura", length = 50)
    private String numeroFactura;

    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private Proveedor proveedor;

    @Column(name = "fecha_movimiento")
    private LocalDateTime fechaMovimiento;

    @Column(name = "usuario_responsable", length = 100)
    private String usuarioResponsable;

    @Column(name = "observaciones", columnDefinition = "TEXT")
    private String observaciones;

    public enum TipoMovimiento {
        entrada, salida, transferencia, ajuste
    }
}
