package br.senac.prjint3.service;

import br.senac.prjint3.model.Cliente;
import br.senac.prjint3.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService extends AbstractCrudService<Cliente> {

    public ClienteService(ClienteRepository repository) {
        super(repository, "Cliente");
    }
}
