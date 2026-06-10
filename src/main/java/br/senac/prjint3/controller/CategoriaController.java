package br.senac.prjint3.controller;

import br.senac.prjint3.model.Categoria;
import br.senac.prjint3.service.CategoriaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categorias")
@Tag(name = "categorias")
public class CategoriaController extends AbstractCrudController<Categoria> {

    public CategoriaController(CategoriaService service) {
        super(service);
    }
}
