package br.desafio.cooperativa.resource.dto;

import br.desafio.cooperativa.resource.domain.Pauta;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PautaRequestDto {

    @NotNull @NotEmpty
    private String titulo;
    @NotNull @NotEmpty
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
