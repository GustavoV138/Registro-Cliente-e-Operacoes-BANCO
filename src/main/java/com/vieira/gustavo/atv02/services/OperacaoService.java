package com.vieira.gustavo.atv02.services;

import com.vieira.gustavo.atv02.entities.ContaEntity;
import com.vieira.gustavo.atv02.entities.OperacaoEntity;
import com.vieira.gustavo.atv02.repositories.ContaRepository;
import com.vieira.gustavo.atv02.repositories.OperacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class OperacaoService {

    private ContaRepository contaRepository;
    private OperacaoRepository operacaoRepository;

    public OperacaoService(OperacaoRepository operacaoRepository, ContaRepository contaRepository) {
        this.operacaoRepository = operacaoRepository;
        this.contaRepository = contaRepository;
    }

    public OperacaoEntity registrarPix(Long id, OperacaoEntity operacao) {
        if(operacao.getValorTransferencia() <= 0) {
            throw new RuntimeException("Valor não pode ser menor ou igual a zero!");
        }

        Optional<ContaEntity> conta = contaRepository.findById(id);
        if(conta.isEmpty()) {
            throw new NullPointerException("Não há contas com este número!");
        }

        Long saldoEmConta = conta.get().getSaldo();
        if(saldoEmConta < operacao.getValorTransferencia()) {
            throw new RuntimeException("Saldo em conta insuficiente!");
        }

        operacao.setCodigoTransacao(null);
        operacao.setConta(conta.get());

        conta.get().setSaldo(saldoEmConta - operacao.getValorTransferencia());

        return operacaoRepository.save(operacao);
    }

    public List<OperacaoEntity> buscarOperacao(Long id) {
        return operacaoRepository.findByContaId(id);
    }
}
