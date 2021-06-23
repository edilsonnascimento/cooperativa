package br.desafio.cooperativa.dto;

import br.desafio.cooperativa.domain.Cooperado;
import br.desafio.cooperativa.resource.CooperadoResource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CooperadoResponseDto {

    private Long codigo;
    private String nome;


    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private static CooperadoResponseDto mapper(Cooperado cooperado){
        CooperadoResponseDto cooperadoResponseDto = new CooperadoResponseDto();
        cooperadoResponseDto.setCodigo(cooperado.getId());
        cooperadoResponseDto.setNome(cooperado.getNome());
        return cooperadoResponseDto;
    }

    public static List<CooperadoResponseDto> converter(List<Cooperado> cooperados) {
        List<CooperadoResponseDto> cooperadoResponseDtos = new ArrayList<>();
        return cooperados.parallelStream().map(CooperadoResponseDto::mapper).collect(Collectors.toList());
    }

}
