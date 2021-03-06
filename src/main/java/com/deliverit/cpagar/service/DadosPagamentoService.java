package com.deliverit.cpagar.service;

import com.deliverit.cpagar.model.ContasPagarModel;
import com.deliverit.cpagar.model.DadosPagamentoModel;
import com.deliverit.cpagar.repository.DadosPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DadosPagamentoService {

    @Autowired
    private DadosPagamentoRepository dadosPagamentoRepository;

    public DadosPagamentoModel save(DadosPagamentoModel dadosPagamentoModel) {
        return this.dadosPagamentoRepository.save(dadosPagamentoModel);
    }

    public List<DadosPagamentoModel> findAll() {
        return this.dadosPagamentoRepository.findAll();
    }
}
