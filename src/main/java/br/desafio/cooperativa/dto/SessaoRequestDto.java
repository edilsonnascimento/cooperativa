package br.desafio.cooperativa.dto;

import br.desafio.cooperativa.domain.Pauta;
import br.desafio.cooperativa.domain.Sessao;
import br.desafio.cooperativa.validacion.PautaException;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class SessaoRequestDto {


    private Long tempoSessao;
    @NotNull
    private Long codigoPauta;

    public Long getCodigoPauta() {
        return codigoPauta;
    }

    public void setCodigoPauta(Long codigoPauta) {
        this.codigoPauta = codigoPauta;
    }

    public Long getTempoSessao() {
        return tempoSessao;
    }

    public void setTempoSessao(Long tempoSessao) {
        this.tempoSessao = tempoSessao;
    }

    public static Sessao converteSessao(SessaoRequestDto sessaoRequestDto, Pauta pauta) throws PautaException {

        if(possuiSessaoVinculada(pauta))  throw new PautaException("Pauta ja vinculada.");
        if(sessaoRequestDto.tempoSessao == null) sessaoRequestDto.setTempoSessao(1l);

        Sessao sessao = new Sessao();
        sessao.vincular(pauta);
        sessao.setTempoSessao(sessaoRequestDto.getTempoSessao());
        sessao.setInicioSessao(LocalDateTime.now());
        sessao.setFimSessao(sessao.getInicioSessao().plusMinutes(sessao.getTempoSessao()));
        return sessao;
    }

    private static boolean possuiSessaoVinculada(Pauta pauta) {
        return pauta.getSessao() != null;
    }

}
