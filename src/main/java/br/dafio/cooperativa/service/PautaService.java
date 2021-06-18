package br.dafio.cooperativa.service;

import br.dafio.cooperativa.domain.Pauta;
import br.dafio.cooperativa.dto.PautaRequestDto;
import br.dafio.cooperativa.dto.PautaResponseDto;
import br.dafio.cooperativa.repositoy.PautaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PautaService {

    @Autowired
    private PautaRepository pautaRepository;



    public Pauta inserir(PautaRequestDto pautaRequestDto) {
        return  pautaRepository.save(PautaRequestDto.mapper(pautaRequestDto));
    }

    public List<PautaResponseDto> lista(String tituloPauta) {
        if(tituloPauta == null) {
            return PautaResponseDto.converter(pautaRepository.findAll());
        }else{
            return PautaResponseDto.converter(pautaRepository.findByTitulo(tituloPauta));
        }
    }

    public PautaResponseDto pauta(Long id) {
        return PautaResponseDto.converter(pautaRepository.findById(id).orElse(new
                Pauta()));
    }
}