package controller;

import DTO.CategoriaResponseDTO;
import Repositorio.CategoriaRepository;
import domain.Categoria;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaRepository repository;

    public CategoriaController(CategoriaRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Categoria> cadastrar(@RequestBody @Valid Categoria categoria) {
        return ResponseEntity.ok(repository.save(categoria));
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponseDTO>> listar() {
        var lista = repository.findAll().stream().map(CategoriaResponseDTO::new).toList();
        return ResponseEntity.ok(lista);
    }
}