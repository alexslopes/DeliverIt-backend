package com.deliverit.cpagar.controller;

import com.deliverit.cpagar.facade.ContasPagarFacade;
import com.deliverit.cpagar.model.ContasPagarModel;
import com.deliverit.cpagar.model.DadosPagamentoModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/contas-pagar")
public class ContasPagarController {

    private final ContasPagarFacade contasPagarFacade;

    public ContasPagarController(ContasPagarFacade contasPagarFacade) {
        this.contasPagarFacade = contasPagarFacade;
    }

    @PostMapping("inserir")
    public DadosPagamentoModel create(@RequestBody ContasPagarModel contasPagarModel) {
        return contasPagarFacade.inserirPagamento(contasPagarModel);
    }

    @GetMapping("pagamentos")
    public List<DadosPagamentoModel> obterPagamento() {
        return contasPagarFacade.obterPagamento();
    }
}
