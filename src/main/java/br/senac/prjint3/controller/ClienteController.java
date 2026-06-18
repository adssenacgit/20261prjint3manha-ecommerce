package br.senac.prjint3.controller;

import br.senac.prjint3.model.Cliente;
import br.senac.prjint3.service.ClienteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/api/clientes")
@Tag(name = "clientes")
@CrossOrigin("*")    
public class ClienteController extends AbstractCrudController<Cliente> {

    public ClienteController(ClienteService service) {
        super(service);
    }
}
