package br.desafio.cooperativa.resource;

import br.desafio.cooperativa.dto.PautaVotacaoResponseDto;
import br.desafio.cooperativa.dto.SessaoRequestDto;
import br.desafio.cooperativa.dto.SessaoResponseDto;
import br.desafio.cooperativa.service.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/sessoes")
public class SessaoResource {

    @Autowired
    private SessaoService service;

    @PostMapping
    public ResponseEntity<?> inserir(@Valid @RequestBody SessaoRequestDto sessaoRequestDto, UriComponentsBuilder builder){
        Optional<SessaoResponseDto> optional = service.inserir(sessaoRequestDto);
        if(!optional.isEmpty()) {
            URI location = builder.path("/sessoes/{id}").buildAndExpand(optional.get().getId()).toUri();
            return ResponseEntity.created(location).build();
        }
            return ResponseEntity.badRequest().body(service.getErroValidacao());
    }

}
