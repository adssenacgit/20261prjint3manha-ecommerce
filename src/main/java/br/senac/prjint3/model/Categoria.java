package br.senac.prjint3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "categoria")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Categoria implements SoftDeletable {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "categoria_id")
private Integer categoriaId;

@NotBlank(message = "O nome da categoria é obrigatório")
@Size(max = 100)
@Column(name = "categoria_nome", nullable = false, length = 100)
private String categoriaNome;

@Lob
@Column(name = "categoria_descricao", columnDefinition = "TEXT")
private String categoriaDescricao;

@Min(-1)
@Max(1)
@Column(name = "categoria_status")
private Integer categoriaStatus;


    public Categoria() {
    }

public Integer getCategoriaId() {
    return categoriaId;
}

public void setCategoriaId(Integer categoriaId) {
    this.categoriaId = categoriaId;
}

public String getCategoriaNome() {
    return categoriaNome;
}

public void setCategoriaNome(String categoriaNome) {
    this.categoriaNome = categoriaNome;
}

public String getCategoriaDescricao() {
    return categoriaDescricao;
}

public void setCategoriaDescricao(String categoriaDescricao) {
    this.categoriaDescricao = categoriaDescricao;
}

public Integer getCategoriaStatus() {
    return categoriaStatus;
}

public void setCategoriaStatus(Integer categoriaStatus) {
    this.categoriaStatus = categoriaStatus;
}


    @Override
    @JsonIgnore
    @Transient
    public Integer getId() {
        return categoriaId;
    }

    @Override
    public void setId(Integer id) {
        this.categoriaId = id;
    }

    @Override
    @JsonIgnore
    @Transient
    public Integer getStatus() {
        return categoriaStatus;
    }

    @Override
    public void setStatus(Integer status) {
        this.categoriaStatus = status;
    }
}
