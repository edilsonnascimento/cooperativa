package br.dafio.cooperativa.dto;

import br.dafio.cooperativa.domain.Cooperado;
import br.dafio.cooperativa.domain.CooperativaDomain;

public class CooperadoDto {

    private String nome;
    private String cpf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public static CooperadoDto converteDto(Cooperado cooperado){
        CooperadoDto cooperadoDto = new CooperadoDto();
        cooperadoDto.setCpf(cooperado.getCpf());
        cooperadoDto.setNome(cooperado.getNome());
        return cooperadoDto;
    }
}
