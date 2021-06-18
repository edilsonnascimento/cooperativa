package br.dafio.cooperativa.dto;

import br.dafio.cooperativa.domain.Pauta;

public class PautaRequestDto {

    private String titulo;
    private String descricao;

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

    public static Pauta mapper(PautaRequestDto pautaRequestDto){
        Pauta pauta = new Pauta();
        pauta.setTitulo(pautaRequestDto.getTitulo());
        pauta.setDescricao(pautaRequestDto.getDescricao());
        return pauta;
    }
}
