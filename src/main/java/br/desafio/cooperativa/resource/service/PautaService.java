package br.desafio.cooperativa.resource.service;

import br.desafio.cooperativa.resource.domain.Pauta;
import br.desafio.cooperativa.resource.dto.PautaRequestAtualizarDto;
import br.desafio.cooperativa.resource.dto.PautaRequestDto;
import br.desafio.cooperativa.resource.dto.PautaResponseDetalhadaDto;
import br.desafio.cooperativa.resource.dto.PautaResponseDto;
import br.desafio.cooperativa.resource.repositoy.PautaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PautaService {

    @Autowired
    private PautaRepository repository;

    public Pauta inserir(PautaRequestDto pautaRequestDto) {
        return  repository.save(PautaRequestDto.mapper(pautaRequestDto));
    }

    public List<PautaResponseDto> lista(String tituloPauta) {
        return tituloPauta == null ? PautaResponseDto.converter(repository.findAll())
                : PautaResponseDto.converter(repository.findByTitulo(tituloPauta));
    }

    public Optional<PautaResponseDetalhadaDto> buscaDetalhada(Long id) {
        Optional<Pauta> pauta = repository.findById(id);
        return pauta.isPresent() ? PautaResponseDetalhadaDto.converter(pauta.get()) : Optional.empty();
    }

    public Boolean atualizar(PautaRequestAtualizarDto pautaRequestDto, Long id) {
        Optional<Pauta> pautaOptional = repository.findById(id);
         if(pautaOptional.isPresent()){
              Pauta pauta = pautaOptional.get();
              pauta.setTitulo(pautaRequestDto.getTitulo());
              pauta.setDescricao(pautaRequestDto.getDescricao());
              return true;
         }
         return false;
    }

    public Boolean remover(Long id) {
        Optional<Pauta> pauta = repository.findById(id);
        if(pauta.isPresent()){
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}