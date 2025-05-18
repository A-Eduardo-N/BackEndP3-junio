package controller;

import Repositorio.LancamentoRepository;
import domain.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lancamentos")
@RequiredArgsConstructor
public class LancamentoController {
    private final LancamentoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<Lancamento> cadastrar(@RequestBody @Valid Lancamento lancamento) {
        return ResponseEntity.ok(repository.save(lancamento));
    }

    @GetMapping
    public ResponseEntity<List<Lancamento>> listar() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lancamento> detalhar(@PathVariable Long id) {
        return repository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Lancamento> atualizar(@PathVariable Long id, @RequestBody @Valid Lancamento dados) {
        return repository.findById(id).map(l -> {
            l = new Lancamento(id, dados.getDescricao(), dados.getDataVencimento(), dados.getDataPagamento(), dados.getValor(), dados.getObservacao(), dados.getTipo(), dados.getCategoria(), dados.getPessoa());
            return ResponseEntity.ok(repository.save(l));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        return repository.findById(id).map(l -> {
            repository.delete(l);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
