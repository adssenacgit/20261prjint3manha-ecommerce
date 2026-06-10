package br.senac.prjint3.service;

import br.senac.prjint3.model.Pedido;
import br.senac.prjint3.repository.PedidoRepository;
import org.springframework.stereotype.Service;

@Service
public class PedidoService extends AbstractCrudService<Pedido> {

    public PedidoService(PedidoRepository repository) {
        super(repository, "Pedido");
    }
}
