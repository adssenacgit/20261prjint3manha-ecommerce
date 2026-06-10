package br.senac.prjint3.service;

import br.senac.prjint3.model.Produto;
import br.senac.prjint3.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService extends AbstractCrudService<Produto> {

    public ProdutoService(ProdutoRepository repository) {
        super(repository, "Produto");
    }
}
