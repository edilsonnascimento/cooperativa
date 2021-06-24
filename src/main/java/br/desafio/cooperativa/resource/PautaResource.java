package br.desafio.cooperativa.resource;


import br.desafio.cooperativa.domain.Pauta;
import br.desafio.cooperativa.dto.PautaRequestAtualizarDto;
import br.desafio.cooperativa.dto.PautaRequestDto;
import br.desafio.cooperativa.dto.PautaResponseDetalhadaDto;
import br.desafio.cooperativa.dto.PautaResponseDto;
import br.desafio.cooperativa.service.PautaService;
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
@RequestMapping("/pautas")
public class PautaResource {

    @Autowired
    private PautaService service;

    @PostMapping
    public ResponseEntity<PautaResponseDto> inserir(@Valid @RequestBody PautaRequestDto pautaRequestDto, UriComponentsBuilder builder){
        Pauta pauta = service.inserir(pautaRequestDto);
        URI location = builder.path("/pautas/{id}").buildAndExpand(pauta.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public List<PautaResponseDto> pautas(String tituloPauta){
        return service.lista(tituloPauta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PautaResponseDetalhadaDto> detalhar(@PathVariable Long id){
        Optional<PautaResponseDetalhadaDto> pautaResponseDetalhada = service.buscaDetalhada(id);
        if(pautaResponseDetalhada.isPresent()){
            return ResponseEntity.ok(pautaResponseDetalhada.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PautaResponseDto> atualizar(@Valid @RequestBody PautaRequestAtualizarDto pautaRequestDto,                                                      @PathVariable Long id) {
        return service.atualizar(pautaRequestDto, id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id) {
        return service.remover(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
