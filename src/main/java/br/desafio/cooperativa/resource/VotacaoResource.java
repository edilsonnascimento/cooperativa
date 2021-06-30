package br.desafio.cooperativa.resource;

import br.desafio.cooperativa.dto.CedulaRequestDto;
import br.desafio.cooperativa.dto.PautaVotacaoResponseDto;
import br.desafio.cooperativa.service.VotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RequestMapping("/votacoes")
@RestController
public class VotacaoResource {


    @Autowired
    private VotacaoService service;

    @PostMapping("/votar")
    @Transactional
    public ResponseEntity<?> votar(@Valid @RequestBody CedulaRequestDto cedulaRequestDto){

        Optional<PautaVotacaoResponseDto> optional = service.votar(cedulaRequestDto);

        return optional.isEmpty() ?
                ResponseEntity.badRequest().body(service.getErroValidacao()) :
                ResponseEntity.ok().body(optional.get());
    }
}
