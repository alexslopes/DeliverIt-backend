package com.deliverit.cpagar.facade;

import com.deliverit.cpagar.model.ContasPagarModel;
import com.deliverit.cpagar.model.DadosPagamentoModel;
import com.deliverit.cpagar.model.MultaJurosModel;
import com.deliverit.cpagar.service.DadosPagamentoService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class ContasPagarFacade {

    private final DadosPagamentoService dadosPagamentoService;

    public ContasPagarFacade(DadosPagamentoService dadosPagamentoService) {
        this.dadosPagamentoService = dadosPagamentoService;
    }

    public void inserirPagamento(ContasPagarModel contasPagarModel) {
        int diferencaDias = verificarDiasAtraso(contasPagarModel.getDataVencimento() ,contasPagarModel.getDataPagamento());
        MultaJurosModel multaJurosModel = valorMultaJuros(diferencaDias);
        DadosPagamentoModel dadosPagamentoModel = DadosPagamentoModel.builder()
                .valorOriginal(contasPagarModel.getValorOriginal())
                .dataVencimento(contasPagarModel.getDataVencimento())
                .dataPagamento(contasPagarModel.getDataPagamento())
                .diasEmAtraso(diferencaDias < 0 ? 0 : diferencaDias)
                .multa(multaJurosModel.getMulta())
                .juros(multaJurosModel.getJuros()).build();

        calcularValorCorrigido(dadosPagamentoModel);

        dadosPagamentoService.save(dadosPagamentoModel);

    }

    public int verificarDiasAtraso(Date dataVencimento, Date dataPagamento) {
        long diferencaMilisegundos = dataPagamento.getTime() - dataVencimento.getTime();
        long diferencaDias = TimeUnit.DAYS.convert(diferencaMilisegundos, TimeUnit.MILLISECONDS);
        return Math.toIntExact(diferencaDias);
    }

    public MultaJurosModel valorMultaJuros(int diasAtraso) {
        if(diasAtraso > 5) {
            return MultaJurosModel.builder().multa(0.05).juros(0.3).build();
        }

        if(diasAtraso > 3) {
            return MultaJurosModel.builder().multa(0.03).juros(0.2).build();
        }

        if(diasAtraso >= 1) {
            return MultaJurosModel.builder().multa(0.02).juros(0.1).build();
        }

        return MultaJurosModel.builder().multa(0).juros(0).build();
    }

    public void calcularValorCorrigido(DadosPagamentoModel dadosPagamentoModel) {
        double valorOriginal = dadosPagamentoModel.getValorOriginal();
        double multa = dadosPagamentoModel.getMulta();
        double juros = dadosPagamentoModel.getJuros();
        int diasAtrasado = dadosPagamentoModel.getDiasEmAtraso();

        double valorCorrigido =  valorOriginal + (valorOriginal*multa) + diasAtrasado*(valorOriginal*juros);

        dadosPagamentoModel.setValorCorrigido(valorCorrigido);
    }
}
