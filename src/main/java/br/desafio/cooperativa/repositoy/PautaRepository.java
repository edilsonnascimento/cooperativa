package br.desafio.cooperativa.repositoy;

import br.desafio.cooperativa.domain.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PautaRepository extends JpaRepository<Pauta, Long> {

    List<Pauta> findByTitulo(String tituloPauta);


}
