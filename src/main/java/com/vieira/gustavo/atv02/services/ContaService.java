package com.vieira.gustavo.atv02.services;

import com.vieira.gustavo.atv02.entities.ContaEntity;
import com.vieira.gustavo.atv02.repositories.ContaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {

    private ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public ContaEntity adicionarConta(ContaEntity conta) {
        return contaRepository.save(conta);
    }

    public List<ContaEntity> pegarTodasContas() {
        return contaRepository.findAll();
    }
}
