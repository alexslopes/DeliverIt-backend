package com.deliverit.cpagar.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DadosPagamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private int id;

    @Column(name = "valor_original")
    private double valorOriginal;

    @Column(name = "valor_corrigido")
    private double valorCorrigido;

    @Column(name = "data_vencimento")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dataVencimento;

    @Column(name = "data_pagamento")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dataPagamento;

    @Column(name = "dias_em_atraso")
    private int diasEmAtraso;

    @Column(name = "multa")
    private double multa;

    @Column(name = "juros")
    private double juros;
}
