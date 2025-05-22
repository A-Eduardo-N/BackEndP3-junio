package controller;
import DTO.LancamentoDTO;
import Repositorio.CategoriaRepository;
import Repositorio.LancamentoRepository;
import Repositorio.PessoaRepository;
import domain.Categoria;
import domain.Lancamento;
import domain.Pessoa;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lancamentos")
@RequiredArgsConstructor
public class LancamentoController {
    private final LancamentoRepository repository;
    private final CategoriaRepository categoriaRepository;
    private final PessoaRepository pessoaRepository;

    public LancamentoController(LancamentoRepository repository, CategoriaRepository categoriaRepository, PessoaRepository pessoaRepository) {
        this.repository = repository;
        this.categoriaRepository = categoriaRepository;
        this.pessoaRepository = pessoaRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Lancamento> cadastrar(@RequestBody @Valid LancamentoDTO dto) {
        Categoria categoria = categoriaRepository.findById(dto.categoriaId()).orElseThrow();
        Pessoa pessoa = pessoaRepository.findById(dto.pessoaId()).orElseThrow();
        Lancamento lancamento = new Lancamento(dto, categoria, pessoa);
        return ResponseEntity.ok(repository.save(lancamento));
    }

    @GetMapping
    public ResponseEntity<List<Lancamento>> listar() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lancamento> detalhar(@PathVariable Long id) {
        return repository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Lancamento> atualizar(@PathVariable Long id, @RequestBody @Valid LancamentoDTO dto) {
        return repository.findById(id).map(l -> {
            Categoria categoria = categoriaRepository.findById(dto.categoriaId()).orElseThrow();
            Pessoa pessoa = pessoaRepository.findById(dto.pessoaId()).orElseThrow();
            l.setDescricao(dto.descricao());
            l.setDataVencimento(dto.dataVencimento());
            l.setDataPagamento(dto.dataPagamento());
            l.setValor(dto.valor());
            l.setObservacao(dto.observacao());
            l.setTipo(dto.tipo());
            l.setCategoria(categoria);
            l.setPessoa(pessoa);
            return ResponseEntity.ok(l);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> excluir(@PathVariable Long id) {
        return repository.findById(id).map(l -> {
            repository.delete(l);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
//@GetMapping("/pessoas/{id}"): define uma rota com uma variável de caminho chamada id.
//@PathVariable Long id: diz ao Spring que o valor {id} da URL deve ser passado para esse parâmetro do método.

//Use @PathVariable quando você quiser:
//Acessar um item específico (ex: /produto/42)
//Fazer operações baseadas em ID (GET, PUT, DELETE)
