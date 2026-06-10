package br.senac.prjint3.controller;

import br.senac.prjint3.model.Pedido;
import br.senac.prjint3.service.PedidoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedidos")
@Tag(name = "pedidos")
public class PedidoController extends AbstractCrudController<Pedido> {

    public PedidoController(PedidoService service) {
        super(service);
    }
}
