package br.senac.prjint3.service;

import br.senac.prjint3.model.ItemPedido;
import br.senac.prjint3.repository.ItemPedidoRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemPedidoService extends AbstractCrudService<ItemPedido> {

    public ItemPedidoService(ItemPedidoRepository repository) {
        super(repository, "Item de pedido");
    }
}
