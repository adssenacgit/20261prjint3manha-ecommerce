package br.senac.prjint3.controller;

import br.senac.prjint3.model.Entrega;
import br.senac.prjint3.service.EntregaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/api/entregas")
@Tag(name = "entregas")
@CrossOrigin("*")    
public class EntregaController extends AbstractCrudController<Entrega> {

    public EntregaController(EntregaService service) {
        super(service);
    }
}
