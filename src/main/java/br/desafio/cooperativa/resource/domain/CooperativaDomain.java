package br.desafio.cooperativa.resource.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

import static java.lang.String.format;
import static java.time.LocalDateTime.now;

@MappedSuperclass
public abstract class CooperativaDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "dt_inclusao", updatable = false)
    protected LocalDateTime dataInclusao;

    @Column(name = "dt_alteracao")
    protected LocalDateTime dataAlteracao;

    public abstract Long getId();

    public CooperativaDomain() {
        super();
        dataInclusao = now();
        dataAlteracao = now();
    }

    public LocalDateTime getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(final LocalDateTime dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(final LocalDateTime dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    @Override
    public String toString() {
        return format("AbstractDomain [dataInclusao=%s, dataAlteracao=%s]", dataInclusao, dataAlteracao);
    }
}
