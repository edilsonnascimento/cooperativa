package br.desafio.cooperativa.service;

import br.desafio.cooperativa.domain.Cooperado;
import br.desafio.cooperativa.dto.CooperadoRequestDto;
import br.desafio.cooperativa.dto.CooperadoResponseDetalhadaDto;
import br.desafio.cooperativa.dto.CooperadoResponseDto;
import br.desafio.cooperativa.repositoy.CooperadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CooperadoService {

    @Autowired
    private CooperadoRepository repository;

    public Long inserir(CooperadoRequestDto cooperadoRequestDto) {
        Optional<Cooperado> optionalCooperado = Optional.ofNullable(repository.save(CooperadoRequestDto.converter(cooperadoRequestDto)));
        if(optionalCooperado.isPresent()){
            return optionalCooperado.get().getId();
        }
        return 0l;
    }

    public Optional<CooperadoResponseDetalhadaDto> buscaDetalhada(Long id) {
        Optional<Cooperado> cooperado = repository.findById(id);
        return cooperado.isPresent() ? CooperadoResponseDetalhadaDto.converter(cooperado.get()) : Optional.empty();
    }

    public Optional<List<CooperadoResponseDto>> listar() {
        return Optional.ofNullable(CooperadoResponseDto.converter(repository.findAll()));
    }
}
