package domain;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    @NotBlank private String logradouro;
    @NotBlank private String numero;
    private String complemento;
    @NotBlank private String bairro;
    @NotBlank private String cep;
    @NotBlank private String cidade;
    @NotBlank private String estado;
}