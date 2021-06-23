package br.desafio.cooperativa.repositoy;

import br.desafio.cooperativa.domain.Cooperado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CooperadoRepository extends JpaRepository<Cooperado, Long> {
}
