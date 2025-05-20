package controller;

import DTO.CategoriaResponseDTO;
import Repositorio.CategoriaRepository;
import domain.Categoria;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
@RequiredArgsConstructor
public class CategoriaController {
    private final CategoriaRepository repository;

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