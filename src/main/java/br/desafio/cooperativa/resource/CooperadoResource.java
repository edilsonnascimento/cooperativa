package br.desafio.cooperativa.resource;

import br.desafio.cooperativa.domain.Cooperado;
import br.desafio.cooperativa.dto.*;
import br.desafio.cooperativa.service.CooperadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
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

    @GetMapping("/{id}")
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

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> atualizar(@Valid @RequestBody CooperadoRequestAtualizarDto cooperadoRequestAtualizarDto, @PathVariable Long id){
        return service.atualizar(cooperadoRequestAtualizarDto, id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){
        return service.remover(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/relatorio/{formato}")
    public String gerarRelatorio(@PathVariable String formato){
        return service.gerarRelatorio(formato);
    }

}
