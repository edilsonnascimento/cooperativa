package br.dafio.cooperativa.dto;

import br.dafio.cooperativa.domain.Pauta;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class PautaResponseDto {


    private String titulo;
    private String descricao;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAlteracao;


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    private static PautaResponseDto mapper(Pauta pauta) {
        PautaResponseDto pautaResponseDto = new PautaResponseDto();
        pautaResponseDto.setTitulo(pauta.getTitulo());
        pautaResponseDto.setDescricao(pauta.getDescricao());
        pautaResponseDto.setDataCadastro(pauta.getDataInclusao());
        pautaResponseDto.setDataAlteracao(pauta.getDataAlteracao());
        return pautaResponseDto;
    }

    public static List<PautaResponseDto> converter(List<Pauta> pautas){
        return pautas.parallelStream().map(PautaResponseDto::mapper).collect(Collectors.toList());
    }

    public static PautaResponseDto converter(Pauta pauta){
        return mapper(pauta);
    }

}
