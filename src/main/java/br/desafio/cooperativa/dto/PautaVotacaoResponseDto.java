package br.desafio.cooperativa.dto;

import br.desafio.cooperativa.domain.Cooperado;
import br.desafio.cooperativa.domain.Pauta;
import br.desafio.cooperativa.domain.Sessao;

import java.time.LocalDateTime;

public class PautaVotacaoResponseDto {

    private Long codigoPauta;
    private String titulo;
    private String descricao;
    private Long codigoSessao;
    private LocalDateTime inicioSessao;
    private LocalDateTime fimSessao;
    private String nomeCooperado;
    private Boolean tipoVoto;

    public Boolean getTipoVoto() {
        return tipoVoto;
    }

    public void setTipoVoto(Boolean tipoVoto) {
        this.tipoVoto = tipoVoto;
    }

    public String getNomeCooperado() {
        return nomeCooperado;
    }

    public void setNomeCooperado(String nomeCooperado) {
        this.nomeCooperado = nomeCooperado;
    }

    public Long getCodigoSessao() {
        return codigoSessao;
    }

    public void setCodigoSessao(Long codigoSessao) {
        this.codigoSessao = codigoSessao;
    }

    public LocalDateTime getInicioSessao() {
        return inicioSessao;
    }

    public void setInicioSessao(LocalDateTime inicioSessao) {
        this.inicioSessao = inicioSessao;
    }

    public LocalDateTime getFimSessao() {
        return fimSessao;
    }

    public void setFimSessao(LocalDateTime fimSessao) {
        this.fimSessao = fimSessao;
    }

    public Long getCodigoPauta() {
        return codigoPauta;
    }

    public void setCodigoPauta(Long codigoPauta) {
        this.codigoPauta = codigoPauta;
    }

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

    public void adiciona(Pauta pauta){
        setCodigoPauta(pauta.getId());
        setTitulo(pauta.getTitulo());
        setDescricao(pauta.getDescricao());
    }

    public void adiciona(Sessao sessao){
        setCodigoSessao(sessao.getId());
        setInicioSessao(sessao.getInicioSessao());
        setFimSessao(sessao.getFimSessao());
    }

    public void adiciona(Cooperado cooperado){
        setNomeCooperado(cooperado.getNome());
    }
}