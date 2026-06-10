package br.senac.prjint3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "endereco")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Endereco implements SoftDeletable {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "endereco_id")
private Integer enderecoId;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "cliente_id")
private Cliente cliente;

@Size(max = 150)
@Column(name = "endereco_rua", length = 150)
private String enderecoRua;

@Size(max = 10)
@Column(name = "endereco_numero", length = 10)
private String enderecoNumero;

@Size(max = 100)
@Column(name = "endereco_bairro", length = 100)
private String enderecoBairro;

@Size(max = 100)
@Column(name = "endereco_cidade", length = 100)
private String enderecoCidade;

@Size(max = 50)
@Column(name = "endereco_estado", length = 50)
private String enderecoEstado;

@Size(max = 10)
@Column(name = "endereco_cep", length = 10)
private String enderecoCep;

@Min(-1)
@Max(1)
@Column(name = "endereco_status")
private Integer enderecoStatus;


    public Endereco() {
    }

public Integer getEnderecoId() {
    return enderecoId;
}

public void setEnderecoId(Integer enderecoId) {
    this.enderecoId = enderecoId;
}

public Cliente getCliente() {
    return cliente;
}

public void setCliente(Cliente cliente) {
    this.cliente = cliente;
}

public String getEnderecoRua() {
    return enderecoRua;
}

public void setEnderecoRua(String enderecoRua) {
    this.enderecoRua = enderecoRua;
}

public String getEnderecoNumero() {
    return enderecoNumero;
}

public void setEnderecoNumero(String enderecoNumero) {
    this.enderecoNumero = enderecoNumero;
}

public String getEnderecoBairro() {
    return enderecoBairro;
}

public void setEnderecoBairro(String enderecoBairro) {
    this.enderecoBairro = enderecoBairro;
}

public String getEnderecoCidade() {
    return enderecoCidade;
}

public void setEnderecoCidade(String enderecoCidade) {
    this.enderecoCidade = enderecoCidade;
}

public String getEnderecoEstado() {
    return enderecoEstado;
}

public void setEnderecoEstado(String enderecoEstado) {
    this.enderecoEstado = enderecoEstado;
}

public String getEnderecoCep() {
    return enderecoCep;
}

public void setEnderecoCep(String enderecoCep) {
    this.enderecoCep = enderecoCep;
}

public Integer getEnderecoStatus() {
    return enderecoStatus;
}

public void setEnderecoStatus(Integer enderecoStatus) {
    this.enderecoStatus = enderecoStatus;
}


    @Override
    @JsonIgnore
    @Transient
    public Integer getId() {
        return enderecoId;
    }

    @Override
    public void setId(Integer id) {
        this.enderecoId = id;
    }

    @Override
    @JsonIgnore
    @Transient
    public Integer getStatus() {
        return enderecoStatus;
    }

    @Override
    public void setStatus(Integer status) {
        this.enderecoStatus = status;
    }
}
