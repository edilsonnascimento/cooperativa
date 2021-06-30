package br.desafio.cooperativa.repositoy;

import br.desafio.cooperativa.domain.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessaoRepository extends JpaRepository<Sessao, Long> {

}
