package Repositorio;

import domain.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {}
