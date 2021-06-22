package br.dafio.cooperativa.resource;


import br.dafio.cooperativa.domain.Pauta;
import br.dafio.cooperativa.dto.PautaRequestAtualizarDto;
import br.dafio.cooperativa.dto.PautaRequestDto;
import br.dafio.cooperativa.dto.PautaResponseDto;
import br.dafio.cooperativa.service.PautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

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
    public PautaResponseDto detalhar(@PathVariable Long id){
       return service.buscaDetalhada(id);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PautaResponseDto> atualizar(@Valid @RequestBody PautaRequestAtualizarDto pautaRequestDto,                                                      @PathVariable Long id) {
        return service.atualizar(pautaRequestDto, id) ? ResponseEntity.noContent().build() : ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<PautaResponseDto> remover(@PathVariable Long id) {
        service.remover(id);
        return ResponseEntity.ok().build();
    }


}
