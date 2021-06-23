package br.desafio.cooperativa.resource.repositoy;

import br.desafio.cooperativa.resource.domain.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PautaRepository extends JpaRepository<Pauta, Long> {

    List<Pauta> findByTitulo(String tituloPauta);


}
