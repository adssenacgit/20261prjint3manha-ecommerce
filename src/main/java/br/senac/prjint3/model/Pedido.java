package br.senac.prjint3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pedido")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pedido implements SoftDeletable {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "pedido_id")
private Integer pedidoId;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "cliente_id")
private Cliente cliente;

@Column(name = "pedido_data")
private LocalDateTime pedidoData;

@Min(-1)
@Max(1)
@Column(name = "pedido_status")
private Integer pedidoStatus;

@DecimalMin(value = "0.00", inclusive = true)
@Column(name = "pedido_valor_total", precision = 10, scale = 2)
private BigDecimal pedidoValorTotal;


    public Pedido() {
    }

@PrePersist
public void prePersist() {
    if (pedidoData == null) {
        pedidoData = LocalDateTime.now();
    }
}

public Integer getPedidoId() {
    return pedidoId;
}

public void setPedidoId(Integer pedidoId) {
    this.pedidoId = pedidoId;
}

public Cliente getCliente() {
    return cliente;
}

public void setCliente(Cliente cliente) {
    this.cliente = cliente;
}

public LocalDateTime getPedidoData() {
    return pedidoData;
}

public void setPedidoData(LocalDateTime pedidoData) {
    this.pedidoData = pedidoData;
}

public Integer getPedidoStatus() {
    return pedidoStatus;
}

public void setPedidoStatus(Integer pedidoStatus) {
    this.pedidoStatus = pedidoStatus;
}

public BigDecimal getPedidoValorTotal() {
    return pedidoValorTotal;
}

public void setPedidoValorTotal(BigDecimal pedidoValorTotal) {
    this.pedidoValorTotal = pedidoValorTotal;
}


    @Override
    @JsonIgnore
    @Transient
    public Integer getId() {
        return pedidoId;
    }

    @Override
    public void setId(Integer id) {
        this.pedidoId = id;
    }

    @Override
    @JsonIgnore
    @Transient
    public Integer getStatus() {
        return pedidoStatus;
    }

    @Override
    public void setStatus(Integer status) {
        this.pedidoStatus = status;
    }
}
