package br.senac.prjint3.service;

import br.senac.prjint3.model.Entrega;
import br.senac.prjint3.repository.EntregaRepository;
import org.springframework.stereotype.Service;

@Service
public class EntregaService extends AbstractCrudService<Entrega> {

    public EntregaService(EntregaRepository repository) {
        super(repository, "Entrega");
    }
}
