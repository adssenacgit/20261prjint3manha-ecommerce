package br.senac.prjint3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pagamentos")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pagamento implements SoftDeletable {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "pagamento_id")
private Integer pagamentoId;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "pedido_id")
private Pedido pedido;

@Size(max = 50)
@Column(name = "pagamento_metodo", length = 50)
private String pagamentoMetodo;

@Min(-1)
@Max(1)
@Column(name = "pagamento_status")
private Integer pagamentoStatus;

@Column(name = "pagamento_data")
private LocalDateTime pagamentoData;


    public Pagamento() {
    }

public Integer getPagamentoId() {
    return pagamentoId;
}

public void setPagamentoId(Integer pagamentoId) {
    this.pagamentoId = pagamentoId;
}

public Pedido getPedido() {
    return pedido;
}

public void setPedido(Pedido pedido) {
    this.pedido = pedido;
}

public String getPagamentoMetodo() {
    return pagamentoMetodo;
}

public void setPagamentoMetodo(String pagamentoMetodo) {
    this.pagamentoMetodo = pagamentoMetodo;
}

public Integer getPagamentoStatus() {
    return pagamentoStatus;
}

public void setPagamentoStatus(Integer pagamentoStatus) {
    this.pagamentoStatus = pagamentoStatus;
}

public LocalDateTime getPagamentoData() {
    return pagamentoData;
}

public void setPagamentoData(LocalDateTime pagamentoData) {
    this.pagamentoData = pagamentoData;
}


    @Override
    @JsonIgnore
    @Transient
    public Integer getId() {
        return pagamentoId;
    }

    @Override
    public void setId(Integer id) {
        this.pagamentoId = id;
    }

    @Override
    @JsonIgnore
    @Transient
    public Integer getStatus() {
        return pagamentoStatus;
    }

    @Override
    public void setStatus(Integer status) {
        this.pagamentoStatus = status;
    }
}
