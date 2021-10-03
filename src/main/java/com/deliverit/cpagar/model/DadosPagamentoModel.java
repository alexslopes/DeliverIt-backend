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

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DadosPagamentoModel {

    @Id
    @GeneratedValue
    private int id;

    @NonNull
    private BigDecimal valorOriginal;

    @NonNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dataVencimento;

    @NonNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dataPagamento;

    @NonNull
    private int diasEmAtraso;

    @NonNull
    private double multa;

    @NonNull
    private double juros;
}
