package br.senac.prjint3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "entregas")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Entrega implements SoftDeletable {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "entrega_id")
private Integer entregaId;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "pedido_id")
private Pedido pedido;

@Size(max = 100)
@Column(name = "entrega_transportadora", length = 100)
private String entregaTransportadora;

@Size(max = 100)
@Column(name = "entrega_codigo_rastreio", length = 100)
private String entregaCodigoRastreio;

@Min(-1)
@Max(1)
@Column(name = "entrega_status")
private Integer entregaStatus;

@Column(name = "entrega_data_envio")
private LocalDateTime entregaDataEnvio;


    public Entrega() {
    }

public Integer getEntregaId() {
    return entregaId;
}

public void setEntregaId(Integer entregaId) {
    this.entregaId = entregaId;
}

public Pedido getPedido() {
    return pedido;
}

public void setPedido(Pedido pedido) {
    this.pedido = pedido;
}

public String getEntregaTransportadora() {
    return entregaTransportadora;
}

public void setEntregaTransportadora(String entregaTransportadora) {
    this.entregaTransportadora = entregaTransportadora;
}

public String getEntregaCodigoRastreio() {
    return entregaCodigoRastreio;
}

public void setEntregaCodigoRastreio(String entregaCodigoRastreio) {
    this.entregaCodigoRastreio = entregaCodigoRastreio;
}

public Integer getEntregaStatus() {
    return entregaStatus;
}

public void setEntregaStatus(Integer entregaStatus) {
    this.entregaStatus = entregaStatus;
}

public LocalDateTime getEntregaDataEnvio() {
    return entregaDataEnvio;
}

public void setEntregaDataEnvio(LocalDateTime entregaDataEnvio) {
    this.entregaDataEnvio = entregaDataEnvio;
}


    @Override
    @JsonIgnore
    @Transient
    public Integer getId() {
        return entregaId;
    }

    @Override
    public void setId(Integer id) {
        this.entregaId = id;
    }

    @Override
    @JsonIgnore
    @Transient
    public Integer getStatus() {
        return entregaStatus;
    }

    @Override
    public void setStatus(Integer status) {
        this.entregaStatus = status;
    }
}
