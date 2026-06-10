package br.senac.prjint3.controller;

import br.senac.prjint3.model.ItemPedido;
import br.senac.prjint3.service.ItemPedidoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/itens-pedido")
@Tag(name = "itens-pedido")
public class ItemPedidoController extends AbstractCrudController<ItemPedido> {

    public ItemPedidoController(ItemPedidoService service) {
        super(service);
    }
}
