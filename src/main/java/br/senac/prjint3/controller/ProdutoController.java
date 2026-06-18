package br.senac.prjint3.controller;

import br.senac.prjint3.model.Produto;
import br.senac.prjint3.service.ProdutoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/api/produtos")
@Tag(name = "produtos")
@CrossOrigin("*")    
public class ProdutoController extends AbstractCrudController<Produto> {

    public ProdutoController(ProdutoService service) {
        super(service);
    }
}
