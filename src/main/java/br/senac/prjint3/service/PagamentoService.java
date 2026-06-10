package br.senac.prjint3.service;

import br.senac.prjint3.model.Pagamento;
import br.senac.prjint3.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService extends AbstractCrudService<Pagamento> {

    public PagamentoService(PagamentoRepository repository) {
        super(repository, "Pagamento");
    }
}
