package DTO;

import domain.TipoLancamento;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public record LancamentoDTO(
        @NotNull String descricao,
        @NotNull LocalDate dataVencimento,
        LocalDate dataPagamento,
        @NotNull BigDecimal valor,
        String observacao,
        @NotNull TipoLancamento tipo,
        @NotNull Long categoriaId,
        @NotNull Long pessoaId
) {}

