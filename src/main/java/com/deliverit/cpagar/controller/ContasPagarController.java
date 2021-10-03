package com.deliverit.cpagar.controller;

import com.deliverit.cpagar.facade.ContasPagarFacade;
import com.deliverit.cpagar.model.ContasPagarModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contas-pagar")
public class ContasPagarController {

    private final ContasPagarFacade contasPagarFacade;

    public ContasPagarController(ContasPagarFacade contasPagarFacade) {
        this.contasPagarFacade = contasPagarFacade;
    }

    @PostMapping("inserir")
    public void create(@RequestBody ContasPagarModel contasPagarModel) {
        contasPagarFacade.inserirPagamento(contasPagarModel);
    }

    @GetMapping("inserir")
    public String create() {
        return "oi";
    }
}
