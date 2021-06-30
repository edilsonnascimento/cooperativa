package br.desafio.cooperativa.service;

import br.desafio.cooperativa.domain.Pauta;
import br.desafio.cooperativa.domain.Sessao;
import br.desafio.cooperativa.dto.ErroValidacaoDto;
import br.desafio.cooperativa.dto.SessaoRequestDto;
import br.desafio.cooperativa.dto.SessaoResponseDto;
import br.desafio.cooperativa.repositoy.PautaRepository;
import br.desafio.cooperativa.repositoy.SessaoRepository;
import br.desafio.cooperativa.validacion.PautaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class SessaoService {

    @Autowired
    private SessaoRepository sessaoRepository;

    @Autowired
    private PautaRepository pautaRepository;

    private ErroValidacaoDto erroValidacao;

    @Transactional
    public Optional<SessaoResponseDto> inserir(SessaoRequestDto sessaoRequestDto){
        try{
            Pauta pauta = Pauta.retornaPauta(sessaoRequestDto.getCodigoPauta(), pautaRepository);
            Sessao sessao = SessaoRequestDto.converteSessao(sessaoRequestDto, pauta);
            sessaoRepository.save(sessao);
            SessaoResponseDto sessaoResponseDto = new SessaoResponseDto();
            sessaoResponseDto.setId(sessao.getId());
            return Optional.ofNullable(sessaoResponseDto);
        }catch (PautaException e) {
            erroValidacao = new ErroValidacaoDto("Pauta", e.getMessage());
            return Optional.empty();
        }
    }

    public ErroValidacaoDto getErroValidacao(){
        return erroValidacao;
    }
}
