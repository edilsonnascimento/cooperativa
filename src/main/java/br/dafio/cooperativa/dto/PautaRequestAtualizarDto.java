package br.dafio.cooperativa.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class PautaRequestAtualizarDto{

    @NotNull @NotEmpty
    private String titulo;
    @NotNull @NotEmpty
    private String descricao;
    private LocalDateTime dataAlteracao;

    public PautaRequestAtualizarDto() {
        this.dataAlteracao = LocalDateTime.now();
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


}
