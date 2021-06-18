package br.dafio.cooperativa.repositoy;

import br.dafio.cooperativa.domain.Pauta;
import br.dafio.cooperativa.dto.PautaResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PautaRepository extends JpaRepository<Pauta, Long> {

    List<Pauta> findByTitulo(String tituloPauta);


}
