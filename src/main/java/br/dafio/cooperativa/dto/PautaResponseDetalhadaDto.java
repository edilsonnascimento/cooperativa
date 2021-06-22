package br.dafio.cooperativa.dto;

import br.dafio.cooperativa.domain.Pauta;

import java.time.LocalDateTime;

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

    public static PautaResponseDetalhadaDto converter(Pauta pauta){
        return mapper(pauta);
    }

}
