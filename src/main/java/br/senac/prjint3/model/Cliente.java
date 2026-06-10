package br.senac.prjint3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cliente")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cliente implements SoftDeletable {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "cliente_id")
private Integer clienteId;

@NotBlank(message = "O nome do cliente é obrigatório")
@Size(max = 100)
@Column(name = "cliente_nome", nullable = false, length = 100)
private String clienteNome;

@NotBlank(message = "O e-mail do cliente é obrigatório")
@Email(message = "E-mail inválido")
@Size(max = 100)
@Column(name = "cliente_email", nullable = false, length = 100)
private String clienteEmail;

@NotBlank(message = "A senha do cliente é obrigatória")
@Size(max = 255)
@Column(name = "cliente_senha", nullable = false, length = 255)
private String clienteSenha;

@Size(max = 20)
@Column(name = "cliente_telefone", length = 20)
private String clienteTelefone;

@Size(max = 14)
@Column(name = "cliente_cpf", length = 14)
private String clienteCpf;

@Column(name = "cliente_data_cadastro")
private LocalDateTime clienteDataCadastro;

@Min(-1)
@Max(1)
@Column(name = "cliente_status")
private Integer clienteStatus;


    public Cliente() {
    }

@PrePersist
public void prePersist() {
    if (clienteDataCadastro == null) {
        clienteDataCadastro = LocalDateTime.now();
    }
}

public Integer getClienteId() {
    return clienteId;
}

public void setClienteId(Integer clienteId) {
    this.clienteId = clienteId;
}

public String getClienteNome() {
    return clienteNome;
}

public void setClienteNome(String clienteNome) {
    this.clienteNome = clienteNome;
}

public String getClienteEmail() {
    return clienteEmail;
}

public void setClienteEmail(String clienteEmail) {
    this.clienteEmail = clienteEmail;
}

public String getClienteSenha() {
    return clienteSenha;
}

public void setClienteSenha(String clienteSenha) {
    this.clienteSenha = clienteSenha;
}

public String getClienteTelefone() {
    return clienteTelefone;
}

public void setClienteTelefone(String clienteTelefone) {
    this.clienteTelefone = clienteTelefone;
}

public String getClienteCpf() {
    return clienteCpf;
}

public void setClienteCpf(String clienteCpf) {
    this.clienteCpf = clienteCpf;
}

public LocalDateTime getClienteDataCadastro() {
    return clienteDataCadastro;
}

public void setClienteDataCadastro(LocalDateTime clienteDataCadastro) {
    this.clienteDataCadastro = clienteDataCadastro;
}

public Integer getClienteStatus() {
    return clienteStatus;
}

public void setClienteStatus(Integer clienteStatus) {
    this.clienteStatus = clienteStatus;
}


    @Override
    @JsonIgnore
    @Transient
    public Integer getId() {
        return clienteId;
    }

    @Override
    public void setId(Integer id) {
        this.clienteId = id;
    }

    @Override
    @JsonIgnore
    @Transient
    public Integer getStatus() {
        return clienteStatus;
    }

    @Override
    public void setStatus(Integer status) {
        this.clienteStatus = status;
    }
}
