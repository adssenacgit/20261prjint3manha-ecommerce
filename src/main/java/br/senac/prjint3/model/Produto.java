package br.senac.prjint3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "produto")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Produto implements SoftDeletable {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "produto_id")
private Integer produtoId;

@NotBlank(message = "O nome do produto é obrigatório")
@Size(max = 150)
@Column(name = "produto_nome", nullable = false, length = 150)
private String produtoNome;

@Lob
@Column(name = "produto_descricao", columnDefinition = "TEXT")
private String produtoDescricao;

@NotNull(message = "O preço do produto é obrigatório")
@DecimalMin(value = "0.00", inclusive = true)
@Column(name = "produto_preco", nullable = false, precision = 10, scale = 2)
private BigDecimal produtoPreco;

@Min(0)
@Column(name = "produto_estoque")
private Integer produtoEstoque;


@Column(name = "produto_imagem", nullable = false, length = 500)
private String produtoImagem;


@Min(-1)
@Max(1)
@Column(name = "produto_status")
private Integer produtoStatus;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "categoria_id")
private Categoria categoria;


    public Produto() {
    }

public Integer getProdutoId() {
    return produtoId;
}

public void setProdutoId(Integer produtoId) {
    this.produtoId = produtoId;
}

public String getProdutoNome() {
    return produtoNome;
}

public void setProdutoNome(String produtoNome) {
    this.produtoNome = produtoNome;
}

public String getProdutoDescricao() {
    return produtoDescricao;
}

public void setProdutoDescricao(String produtoDescricao) {
    this.produtoDescricao = produtoDescricao;
}

public BigDecimal getProdutoPreco() {
    return produtoPreco;
}

public void setProdutoPreco(BigDecimal produtoPreco) {
    this.produtoPreco = produtoPreco;
}

public Integer getProdutoEstoque() {
    return produtoEstoque;
}

public void setProdutoEstoque(Integer produtoEstoque) {
    this.produtoEstoque = produtoEstoque;
}

public String getProdutoImagem() {
    return produtoImagem;
}

public void setProdutoImagem(String produtoImagem) {
    this.produtoImagem = produtoImagem;
}

    public Integer getProdutoStatus() {
    return produtoStatus;
}

public void setProdutoStatus(Integer produtoStatus) {
    this.produtoStatus = produtoStatus;
}

public Categoria getCategoria() {
    return categoria;
}

public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
}


    @Override
    @JsonIgnore
    @Transient
    public Integer getId() {
        return produtoId;
    }

    @Override
    public void setId(Integer id) {
        this.produtoId = id;
    }

    @Override
    @JsonIgnore
    @Transient
    public Integer getStatus() {
        return produtoStatus;
    }

    @Override
    public void setStatus(Integer status) {
        this.produtoStatus = status;
    }
}
