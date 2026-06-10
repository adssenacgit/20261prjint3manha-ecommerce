package br.senac.prjint3.service;

import br.senac.prjint3.model.Endereco;
import br.senac.prjint3.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService extends AbstractCrudService<Endereco> {

    public EnderecoService(EnderecoRepository repository) {
        super(repository, "Endereço");
    }
}
