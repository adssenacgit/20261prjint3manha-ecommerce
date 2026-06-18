package br.senac.prjint3.controller;

import br.senac.prjint3.model.Endereco;
import br.senac.prjint3.service.EnderecoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/api/enderecos")
@Tag(name = "enderecos")
@CrossOrigin("*")    
public class EnderecoController extends AbstractCrudController<Endereco> {

    public EnderecoController(EnderecoService service) {
        super(service);
    }
}
