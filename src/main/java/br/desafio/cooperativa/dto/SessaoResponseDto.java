package br.desafio.cooperativa.dto;

import java.time.LocalDateTime;

public class SessaoResponseDto {

    private Long id;
    private LocalDateTime inicioSessao;
    private LocalDateTime fimSesao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getInicioSessao() {
        return inicioSessao;
    }

    public void setInicioSessao(LocalDateTime inicioSessao) {
        this.inicioSessao = inicioSessao;
    }

    public LocalDateTime getFimSesao() {
        return fimSesao;
    }

    public void setFimSesao(LocalDateTime fimSesao) {
        this.fimSesao = fimSesao;
    }
}
