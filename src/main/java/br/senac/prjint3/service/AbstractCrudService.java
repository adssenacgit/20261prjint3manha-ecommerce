package br.senac.prjint3.service;

import br.senac.prjint3.exception.InvalidStatusException;
import br.senac.prjint3.exception.ResourceNotFoundException;
import br.senac.prjint3.model.SoftDeletable;
import br.senac.prjint3.model.StatusRegistro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

public abstract class AbstractCrudService<T extends SoftDeletable> {

    private final JpaRepository<T, Integer> repository;
    private final String resourceName;

    protected AbstractCrudService(JpaRepository<T, Integer> repository, String resourceName) {
        this.repository = repository;
        this.resourceName = resourceName;
    }

    @Transactional(readOnly = true)
    public List<T> listarTodosNaoApagados() {
        return repository.findAll()
                .stream()
                .filter(entity -> !Objects.equals(entity.getStatus(), StatusRegistro.APAGADO))
                .toList();
    }

    @Transactional(readOnly = true)
    public List<T> listarPorStatus(Integer status) {
        validarStatus(status);
        return repository.findAll()
                .stream()
                .filter(entity -> Objects.equals(entity.getStatus(), status))
                .toList();
    }

    @Transactional(readOnly = true)
    public T buscarPorId(Integer id) {
        T entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(resourceName + " não encontrado(a) com ID " + id));

        if (Objects.equals(entity.getStatus(), StatusRegistro.APAGADO)) {
            throw new ResourceNotFoundException(resourceName + " não encontrado(a) com ID " + id);
        }

        return entity;
    }

    @Transactional
    public T criar(T entity) {
        entity.setId(null);
        if (entity.getStatus() == null) {
            entity.setStatus(StatusRegistro.ATIVO);
        }
        validarStatus(entity.getStatus());
        return repository.save(entity);
    }

    @Transactional
    public T atualizar(Integer id, T entity) {
        T entityAtual = buscarPorId(id);

        if (entity.getStatus() == null) {
            entity.setStatus(entityAtual.getStatus());
        }

        validarStatus(entity.getStatus());
        entity.setId(id);
        return repository.save(entity);
    }

    @Transactional
    public T alterarStatus(Integer id, Integer status) {
        validarStatus(status);
        T entity = buscarPorId(id);
        entity.setStatus(status);
        return repository.save(entity);
    }

    @Transactional
    public void apagarLogicamente(Integer id) {
        T entity = buscarPorId(id);
        entity.setStatus(StatusRegistro.APAGADO);
        repository.save(entity);
    }

    private void validarStatus(Integer status) {
        if (!StatusRegistro.isValido(status)) {
            throw new InvalidStatusException("Status inválido. Use -1 para apagado, 0 para inativo ou 1 para ativo.");
        }
    }
}
