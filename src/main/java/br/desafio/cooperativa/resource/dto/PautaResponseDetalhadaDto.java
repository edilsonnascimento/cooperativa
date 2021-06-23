package br.desafio.cooperativa.resource.dto;

import br.desafio.cooperativa.resource.domain.Pauta;

import java.time.LocalDateTime;
import java.util.Optional;

public class PautaResponseDetalhadaDto extends PautaResponseDto{

    private String descricao;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAlteracao;


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

    private static PautaResponseDetalhadaDto mapper(Pauta pauta) {
        PautaResponseDetalhadaDto pautaResponseDetalhadaDto = new PautaResponseDetalhadaDto();
        pautaResponseDetalhadaDto.setTitulo(pauta.getTitulo());
        pautaResponseDetalhadaDto.setDescricao(pauta.getDescricao());
        pautaResponseDetalhadaDto.setDataCadastro(pauta.getDataInclusao());
        pautaResponseDetalhadaDto.setDataAlteracao(pauta.getDataAlteracao());
        return pautaResponseDetalhadaDto;
    }

    public static Optional<PautaResponseDetalhadaDto> converter(Pauta pauta){
       return Optional.ofNullable(mapper(pauta));
    }

}
