package br.senac.prjint3.service;

import br.senac.prjint3.model.Categoria;
import br.senac.prjint3.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService extends AbstractCrudService<Categoria> {

    public CategoriaService(CategoriaRepository repository) {
        super(repository, "Categoria");
    }
}
