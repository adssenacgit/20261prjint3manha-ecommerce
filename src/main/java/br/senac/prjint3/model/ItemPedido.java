package br.senac.prjint3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "itens_pedido")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ItemPedido implements SoftDeletable {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "item_pedido_id")
private Integer itemPedidoId;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "pedido_id")
private Pedido pedido;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "produto_id")
private Produto produto;

@Min(1)
@Column(name = "item_pedido_quantidade")
private Integer itemPedidoQuantidade;

@DecimalMin(value = "0.00", inclusive = true)
@Column(name = "item_pedido_preco", precision = 10, scale = 2)
private BigDecimal itemPedidoPreco;

@Min(-1)
@Max(1)
@Column(name = "item_pedido_status")
private Integer itemPedidoStatus;


    public ItemPedido() {
    }

public Integer getItemPedidoId() {
    return itemPedidoId;
}

public void setItemPedidoId(Integer itemPedidoId) {
    this.itemPedidoId = itemPedidoId;
}

public Pedido getPedido() {
    return pedido;
}

public void setPedido(Pedido pedido) {
    this.pedido = pedido;
}

public Produto getProduto() {
    return produto;
}

public void setProduto(Produto produto) {
    this.produto = produto;
}

public Integer getItemPedidoQuantidade() {
    return itemPedidoQuantidade;
}

public void setItemPedidoQuantidade(Integer itemPedidoQuantidade) {
    this.itemPedidoQuantidade = itemPedidoQuantidade;
}

public BigDecimal getItemPedidoPreco() {
    return itemPedidoPreco;
}

public void setItemPedidoPreco(BigDecimal itemPedidoPreco) {
    this.itemPedidoPreco = itemPedidoPreco;
}

public Integer getItemPedidoStatus() {
    return itemPedidoStatus;
}

public void setItemPedidoStatus(Integer itemPedidoStatus) {
    this.itemPedidoStatus = itemPedidoStatus;
}


    @Override
    @JsonIgnore
    @Transient
    public Integer getId() {
        return itemPedidoId;
    }

    @Override
    public void setId(Integer id) {
        this.itemPedidoId = id;
    }

    @Override
    @JsonIgnore
    @Transient
    public Integer getStatus() {
        return itemPedidoStatus;
    }

    @Override
    public void setStatus(Integer status) {
        this.itemPedidoStatus = status;
    }
}
