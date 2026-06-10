package br.senac.prjint3.controller;

import br.senac.prjint3.model.SoftDeletable;
import br.senac.prjint3.model.StatusRegistro;
import br.senac.prjint3.service.AbstractCrudService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class AbstractCrudController<T extends SoftDeletable> {

    private final AbstractCrudService<T> service;

    protected AbstractCrudController(AbstractCrudService<T> service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<T>> listarTodosNaoApagados() {
        return ResponseEntity.ok(service.listarTodosNaoApagados());
    }

    @GetMapping("/ativos")
    public ResponseEntity<List<T>> listarAtivos() {
        return ResponseEntity.ok(service.listarPorStatus(StatusRegistro.ATIVO));
    }

    @GetMapping("/inativos")
    public ResponseEntity<List<T>> listarInativos() {
        return ResponseEntity.ok(service.listarPorStatus(StatusRegistro.INATIVO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<T> criar(@Valid @RequestBody T entity) {
        T criado = service.criar(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> atualizar(@PathVariable Integer id, @Valid @RequestBody T entity) {
        return ResponseEntity.ok(service.atualizar(id, entity));
    }

    @PatchMapping("/{id}/ativar")
    public ResponseEntity<T> ativar(@PathVariable Integer id) {
        return ResponseEntity.ok(service.alterarStatus(id, StatusRegistro.ATIVO));
    }

    @PatchMapping("/{id}/inativar")
    public ResponseEntity<T> inativar(@PathVariable Integer id) {
        return ResponseEntity.ok(service.alterarStatus(id, StatusRegistro.INATIVO));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void apagarLogicamente(@PathVariable Integer id) {
        service.apagarLogicamente(id);
    }
}
