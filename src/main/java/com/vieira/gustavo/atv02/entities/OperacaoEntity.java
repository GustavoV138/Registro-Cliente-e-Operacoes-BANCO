package com.vieira.gustavo.atv02.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_operacoes")
public class OperacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigoTransacao;

    private String tipoOperacao;
    private Long valorTransferencia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conta_id")
    @JsonBackReference
    private ContaEntity conta;

    public OperacaoEntity() {
    }

    public OperacaoEntity(String tipoOperacao, Long valorTransferencia, ContaEntity conta) {
        this.tipoOperacao = tipoOperacao;
        this.valorTransferencia = valorTransferencia;
        this.conta = conta;
    }

    public Long getCodigoTransacao() {
        return codigoTransacao;
    }
    public void setCodigoTransacao(Long codigoTransacao) {
        this.codigoTransacao = codigoTransacao;
    }

    public String getTipoOperacao() {
        return tipoOperacao;
    }
    public void setTipoOperacao(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public Long getValorTransferencia() {
        return valorTransferencia;
    }
    public void setValorTransferencia(Long valorTransferencia) {
        this.valorTransferencia = valorTransferencia;
    }

    public ContaEntity getConta() {
        return conta;
    }
    public void setConta(ContaEntity conta) {
        this.conta = conta;
    }
}
