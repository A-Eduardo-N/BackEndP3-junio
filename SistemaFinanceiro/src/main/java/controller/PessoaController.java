package controller;

import DTO.PessoaResponseDTO;
import Repositorio.PessoaRepository;
import domain.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    private final PessoaRepository repository;
    public PessoaController(PessoaRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Pessoa> cadastrar(@RequestBody @Valid Pessoa pessoa) {
        return ResponseEntity.ok(repository.save(pessoa));
    }

    @GetMapping
    public ResponseEntity<List<PessoaResponseDTO>> listar() {
        var lista = repository.findAll().stream().map(PessoaResponseDTO::new).toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/ativas")
    public ResponseEntity<List<PessoaResponseDTO>> listarAtivas() {
        var lista = repository.findByAtivoTrue().stream().map(PessoaResponseDTO::new).toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaResponseDTO> detalhar(@PathVariable Long id) {
        return repository.findById(id).map(p -> ResponseEntity.ok(new PessoaResponseDTO(p))).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Pessoa> atualizar(@PathVariable Long id, @RequestBody @Valid Pessoa dados) {
        return repository.findById(id).map(p -> {
            p.setNome(dados.getNome());
            p.setAtivo(dados.isAtivo());
            p.setEndereco(dados.getEndereco());
            return ResponseEntity.ok(p);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> excluir(@PathVariable Long id) {
        return repository.findById(id).map(p -> {
            repository.delete(p);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}