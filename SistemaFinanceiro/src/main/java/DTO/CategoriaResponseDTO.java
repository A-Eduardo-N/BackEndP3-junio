package DTO;

import domain.Categoria;

public record CategoriaResponseDTO(
        Long id,
        String name
) {
    public CategoriaResponseDTO(Categoria categoria) {
        this(categoria.getId(), categoria.getName());
    }
}
