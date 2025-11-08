package com.vieira.gustavo.atv02.controller;

import com.vieira.gustavo.atv02.entities.ContaEntity;
import com.vieira.gustavo.atv02.entities.OperacaoEntity;
import com.vieira.gustavo.atv02.services.ContaService;
import com.vieira.gustavo.atv02.services.OperacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banco")
public class ContaController {

    private ContaService contaService;
    private OperacaoService operacaoService;

    public ContaController(ContaService contaService, OperacaoService operacaoService) {
        this.contaService = contaService;
        this.operacaoService = operacaoService;
    }

    @GetMapping("/contas")
    public List<ContaEntity> exibirTodasContas() {
        return contaService.pegarTodasContas();
    }

    @PostMapping("/contas/adicionarConta")
    public ContaEntity adicionarConta(@RequestBody ContaEntity conta) {
        return contaService.adicionarConta(conta);
    }

    @PostMapping("/operacao/{id}/pix")
    public ResponseEntity<OperacaoEntity> fazerPix(@PathVariable Long id, @RequestBody OperacaoEntity operacao) {
        return ResponseEntity.ok(operacaoService.registrarPix(id, operacao));
    }

    @GetMapping("/operacao/{id}")
    public ResponseEntity<List<OperacaoEntity>> buscarOperacoes(@PathVariable Long id) {
        return ResponseEntity.ok(operacaoService.buscarOperacao(id));
    }

}
