package com.deliverit.cpagar.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ContasPagarModel {

    @Id
    @GeneratedValue
    private int id;

    @NonNull
    private String nome;

    @NonNull
    private double valorOriginal;

    @NonNull
    @JsonFormat(pattern="yyyy-MM-dd", locale = "pt-BR", timezone = "Brazil/East")
    private Date dataVencimento;

    @NonNull
    @JsonFormat(pattern="yyyy-MM-dd", locale = "pt-BR", timezone = "Brazil/East")
    private Date dataPagamento;
}
