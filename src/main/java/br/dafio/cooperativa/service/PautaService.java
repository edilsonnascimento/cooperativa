package br.dafio.cooperativa.service;

import br.dafio.cooperativa.domain.Pauta;
import br.dafio.cooperativa.dto.PautaRequestAtualizarDto;
import br.dafio.cooperativa.dto.PautaRequestDto;
import br.dafio.cooperativa.dto.PautaResponseDetalhadaDto;
import br.dafio.cooperativa.dto.PautaResponseDto;
import br.dafio.cooperativa.repositoy.PautaRepository;
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

    public PautaResponseDetalhadaDto buscaDetalhada(Long id) {
        Optional<Pauta> pauta = repository.findById(id);
        return pauta.isPresent() ? PautaResponseDetalhadaDto.converter(pauta.get()) : new PautaResponseDetalhadaDto();
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

    public void remover(Long id) {
        repository.deleteById(id);
    }
}