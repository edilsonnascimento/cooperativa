package br.desafio.cooperativa.dto;

import br.desafio.cooperativa.domain.Cooperado;

import java.time.LocalDateTime;
import java.util.Optional;

public class CooperadoResponseDetalhadaDto {

    private Long id;
    private String nome;
    private String documentoNacional;
    private LocalDateTime dataAlteracao;
    private LocalDateTime dataCriacao;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumentoNacional() {
        return documentoNacional;
    }

    public void setDocumentoNacional(String documentoNacional) {
        this.documentoNacional = documentoNacional;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public static Optional<CooperadoResponseDetalhadaDto> converter(Cooperado cooperado) {
        CooperadoResponseDetalhadaDto cooperadoResponseDetalhadaDto = new CooperadoResponseDetalhadaDto();
        cooperadoResponseDetalhadaDto.setId(cooperado.getId());
        cooperadoResponseDetalhadaDto.setNome(cooperado.getNome());
        cooperadoResponseDetalhadaDto.setDocumentoNacional(cooperado.getDocumentoNacional());
        cooperadoResponseDetalhadaDto.setDataCriacao(cooperado.getDataInclusao());
        cooperadoResponseDetalhadaDto.setDataAlteracao(cooperado.getDataAlteracao());
        return Optional.ofNullable(cooperadoResponseDetalhadaDto);
    }

}
