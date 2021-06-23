package br.desafio.cooperativa.dto;

import br.desafio.cooperativa.domain.Cooperado;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CooperadoRequestDto {

    @NotNull @NotEmpty
    private String nome;
    @NotNull @NotEmpty @Length(min = 11, max = 14)
    private String documentoNascional;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumentoNascional() {
        return documentoNascional;
    }

    public void setDocumentoNascional(String documentoNascional) {
        this.documentoNascional = documentoNascional;
    }

    public static Cooperado converter(CooperadoRequestDto cooperadoRequestDto) {
        Cooperado cooperado = new Cooperado();
        cooperado.setNome(cooperadoRequestDto.getNome());
        cooperado.setDocumentoNacional(cooperadoRequestDto.getDocumentoNascional());
        return cooperado;
    }


}
