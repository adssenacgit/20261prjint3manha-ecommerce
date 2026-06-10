package br.senac.prjint3.controller;

import br.senac.prjint3.model.Pagamento;
import br.senac.prjint3.service.PagamentoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pagamentos")
@Tag(name = "pagamentos")
public class PagamentoController extends AbstractCrudController<Pagamento> {

    public PagamentoController(PagamentoService service) {
        super(service);
    }
}
