package br.desafio.cooperativa.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class CooperadoRequestAtualizarDto {

    @NotEmpty @NotNull
    private String nome;
    @NotEmpty @NotNull @Length(min = 11, max = 14)
    private String documentoNacional;

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

}
