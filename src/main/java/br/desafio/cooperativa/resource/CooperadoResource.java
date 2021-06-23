package br.desafio.cooperativa.resource;

import br.desafio.cooperativa.domain.Cooperado;
import br.desafio.cooperativa.dto.CooperadoRequestDto;
import br.desafio.cooperativa.dto.CooperadoResponseDetalhadaDto;
import br.desafio.cooperativa.dto.CooperadoResponseDto;
import br.desafio.cooperativa.dto.PautaResponseDetalhadaDto;
import br.desafio.cooperativa.service.CooperadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cooperados")
public class CooperadoResource {

    @Autowired
    private CooperadoService service;

    @PostMapping
    public ResponseEntity<?> inserir(@Valid @RequestBody CooperadoRequestDto cooperadoRequestDto, UriComponentsBuilder builder){
        Long id = service.inserir(cooperadoRequestDto);
        if(id > 0){
            URI location = builder.path("/cooperados/{id}").buildAndExpand(id).toUri();
            return ResponseEntity.created(location).build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<CooperadoResponseDetalhadaDto> detalhar(@PathVariable Long id){
        Optional<CooperadoResponseDetalhadaDto> cooperadoResponseDetalhada = service.buscaDetalhada(id);
        if(cooperadoResponseDetalhada.isPresent()){
            return ResponseEntity.ok(cooperadoResponseDetalhada.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<CooperadoResponseDto>>listar(){
        Optional<List<CooperadoResponseDto>> lista = service.listar();
        if(lista.isPresent()){
            return ResponseEntity.ok(lista.get());
        }
        return ResponseEntity.noContent().build();
    }
}
