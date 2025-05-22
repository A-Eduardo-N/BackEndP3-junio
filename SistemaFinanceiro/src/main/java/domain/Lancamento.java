package domain;

import DTO.LancamentoDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Lancamento {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @NotNull
    private LocalDate dataVencimento;

    private LocalDate dataPagamento;

    @NotNull
    private BigDecimal valor;

    private String observacao;

    @Enumerated(EnumType.STRING)
    private TipoLancamento tipo;

    @ManyToOne
    @NotNull
    private Categoria categoria;

    @ManyToOne
    @NotNull
    private Pessoa pessoa;

    public Lancamento(LancamentoDTO dto, Categoria categoria, Pessoa pessoa) {
        this.descricao = dto.descricao();
        this.dataVencimento = dto.dataVencimento();
        this.dataPagamento = dto.dataPagamento();
        this.valor = dto.valor();
        this.observacao = dto.observacao();
        this.tipo = dto.tipo();
        this.categoria = categoria;
        this.pessoa = pessoa;
    }

    public void setDescricao(@NotNull String descricao) {
    }

    public void setDataVencimento(@NotNull LocalDate localDate) {
    }

    public void setDataPagamento(LocalDate localDate) {
    }

    public void setValor(@NotNull BigDecimal valor) {
    }

    public void setObservacao(String observacao) {
    }

    public void setTipo(@NotNull TipoLancamento tipo) {
    }

    public void setCategoria(Categoria categoria) {
    }

    public void setPessoa(Pessoa pessoa) {
    }
}