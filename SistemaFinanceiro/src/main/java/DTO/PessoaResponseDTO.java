package DTO;

import domain.Endereco;
import domain.Pessoa;

public record PessoaResponseDTO(
        Long id,
        String nome,
        boolean ativo,
        Endereco endereco
) {
    public PessoaResponseDTO(Pessoa pessoa) {
        this(pessoa.getId(), pessoa.getNome(), pessoa.isAtivo(), pessoa.getEndereco());
    }
}
