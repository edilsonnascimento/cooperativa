package br.desafio.cooperativa.dto;

import br.desafio.cooperativa.domain.Pauta;

import java.util.List;
import java.util.stream.Collectors;

public class PautaResponseDto {


    private Long codigo;
    private String titulo;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    private static PautaResponseDto mapper(Pauta pauta) {
        PautaResponseDto pautaResponseDto = new PautaResponseDto();
        pautaResponseDto.setCodigo(pauta.getId());
        pautaResponseDto.setTitulo(pauta.getTitulo());
        return pautaResponseDto;
    }

    public static List<PautaResponseDto> converter(List<Pauta> pautas){
        return pautas.parallelStream().map(PautaResponseDto::mapper).collect(Collectors.toList());
    }

}
