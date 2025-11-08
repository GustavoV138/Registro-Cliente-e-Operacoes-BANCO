package com.vieira.gustavo.atv02.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_contas")
public class ContaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do cliente deve ser informado!")
    private String nomeCliente;

    private Long numConta;
    private Long saldo;

    @OneToMany(mappedBy = "conta", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonBackReference
    private List<OperacaoEntity> operacoes = new ArrayList<>();

    public ContaEntity() {
    }

    public ContaEntity(String nomeCliente, Long numConta, Long saldo, List<OperacaoEntity> operacoes) {
        this.numConta = numConta;
        this.numConta = numConta;
        this.saldo = saldo;
        this.operacoes = operacoes;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Long getNumConta() {
        return numConta;
    }
    public void setNumConta(Long numConta) {
        this.numConta = numConta;
    }

    public Long getSaldo() {
        return saldo;
    }
    public void setSaldo(Long saldo) {
        this.saldo = saldo;
    }

    public List<OperacaoEntity> getOperacoes() {
        return operacoes;
    }
    public void setOperacoes(List<OperacaoEntity> operacoes) {
        this.operacoes = operacoes;
    }

}
