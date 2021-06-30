package br.desafio.cooperativa.service;

import br.desafio.cooperativa.domain.Cooperado;
import br.desafio.cooperativa.domain.Pauta;
import br.desafio.cooperativa.domain.Sessao;
import br.desafio.cooperativa.dto.ErroValidacaoDto;
import br.desafio.cooperativa.dto.CedulaRequestDto;
import br.desafio.cooperativa.dto.PautaVotacaoResponseDto;
import br.desafio.cooperativa.repositoy.CooperadoRepository;
import br.desafio.cooperativa.repositoy.PautaRepository;
import br.desafio.cooperativa.repositoy.SessaoRepository;
import br.desafio.cooperativa.validacion.CooperadoException;
import br.desafio.cooperativa.validacion.PautaException;
import br.desafio.cooperativa.validacion.SessaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VotacaoService {

    @Autowired
    private SessaoRepository sessaoRepository;

    @Autowired
    private PautaRepository pautaRepository;

    @Autowired
    private CooperadoRepository cooperadoRepository;

    private ErroValidacaoDto erroValidacao;

    public Optional<PautaVotacaoResponseDto> votar(CedulaRequestDto cedulaRequestDto) {

        PautaVotacaoResponseDto pautaVotacaoResponseDto = new PautaVotacaoResponseDto();

        try {
            Pauta pauta = Pauta.retornaPauta(cedulaRequestDto.getIdPauta(), pautaRepository);
            pautaVotacaoResponseDto.adiciona(pauta);

            Sessao sessao = Sessao.retornaSessao(cedulaRequestDto.getIdSessao(), sessaoRepository);
            pautaVotacaoResponseDto.adiciona(sessao);

            Cooperado cooperado = Cooperado.retornaCooperado(cedulaRequestDto.getIdCooperado(),cooperadoRepository);
            pautaVotacaoResponseDto.adiciona(cooperado);

            contabilizarVoto(cedulaRequestDto.getVoto(), pauta);
            pautaVotacaoResponseDto.setTipoVoto(cedulaRequestDto.getVoto());

            return Optional.ofNullable(pautaVotacaoResponseDto);

        }catch (PautaException e){
            erroValidacao = new ErroValidacaoDto("Pauta", e.getMessage());
            return Optional.empty();
        }catch (SessaoException e){
            erroValidacao = new ErroValidacaoDto("Sessão", e.getMessage());
            return Optional.empty();
        }catch (CooperadoException e){
            erroValidacao = new ErroValidacaoDto("Cooperado", e.getMessage());
            return Optional.empty();
        }

    }

    private void contabilizarVoto(Boolean voto, Pauta pauta) {
        if (voto) {
            pauta.somaVotosSim();
        } else {
            pauta.somaVotoNao();
        }
    }

    public ErroValidacaoDto getErroValidacao(){
        return erroValidacao;
    }
}
