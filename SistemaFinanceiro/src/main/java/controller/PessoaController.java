package controller;

import domain.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
@RequiredArgsConstructor
public class PessoaController {
    private final PessoaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<Pessoa> cadastrar(@RequestBody @Valid Pessoa pessoa) {
        return ResponseEntity.ok(repository.save(pessoa));
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> listar() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/ativas")
    public ResponseEntity<List<Pessoa>> listarAtivas() {
        return ResponseEntity.ok(repository.findByAtivoTrue());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> detalhar(@PathVariable Long id) {
        return repository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Pessoa> atualizar(@PathVariable Long id, @RequestBody @Valid Pessoa dados) {
        return repository.findById(id).map(p -> {
            p = new Pessoa(id, dados.getNome(), dados.getAtivo(), dados.getEndereco());
            return ResponseEntity.ok(repository.save(p));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        return repository.findById(id).map(p -> {
            repository.delete(p);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}