package br.senac.prjint3.controller;

import br.senac.prjint3.model.Cliente;
import br.senac.prjint3.service.ClienteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientes")
@Tag(name = "clientes")
public class ClienteController extends AbstractCrudController<Cliente> {

    public ClienteController(ClienteService service) {
        super(service);
    }
}
