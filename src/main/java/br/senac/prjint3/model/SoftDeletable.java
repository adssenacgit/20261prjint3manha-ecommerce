package br.senac.prjint3.model;

public interface SoftDeletable {
    Integer getId();
    void setId(Integer id);
    Integer getStatus();
    void setStatus(Integer status);
}
