package br.desafio.cooperativa.dto;

import javax.validation.constraints.NotNull;

public class CedulaRequestDto {

    @NotNull
    private Long idPauta;
    @NotNull
    private Long idSessao;
    @NotNull
    private Long idCooperado;
    @NotNull
    private Boolean voto;

    public Long getIdPauta() {
        return idPauta;
    }

    public void setIdPauta(Long idPauta) {
        this.idPauta = idPauta;
    }

    public Long getIdSessao() {
        return idSessao;
    }

    public void setIdSessao(Long idSessao) {
        this.idSessao = idSessao;
    }

    public Long getIdCooperado() {
        return idCooperado;
    }

    public void setIdCooperado(Long idCooperado) {
        this.idCooperado = idCooperado;
    }

    public Boolean getVoto() {
        return voto;
    }

    public void setVoto(Boolean voto) {
        this.voto = voto;
    }
}
