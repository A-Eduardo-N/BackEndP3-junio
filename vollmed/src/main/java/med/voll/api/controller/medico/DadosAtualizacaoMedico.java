package med.voll.api.controller.medico;

import med.voll.api.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;


public record DadosAtualizacaoMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}