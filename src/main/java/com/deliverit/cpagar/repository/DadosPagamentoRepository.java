package com.deliverit.cpagar.repository;

import com.deliverit.cpagar.model.DadosPagamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DadosPagamentoRepository extends JpaRepository<DadosPagamentoModel, Integer> {
}
