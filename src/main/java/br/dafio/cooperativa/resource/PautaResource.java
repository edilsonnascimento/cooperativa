package br.dafio.cooperativa.resource;


import br.dafio.cooperativa.domain.Pauta;
import br.dafio.cooperativa.dto.PautaRequestDto;
import br.dafio.cooperativa.dto.PautaResponseDto;
import br.dafio.cooperativa.service.PautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pautas")
public class PautaResource {

    @Autowired
    private PautaService pautaService;

    @PostMapping
    public ResponseEntity<?> inserir(@RequestBody PautaRequestDto pautaRequestDto, UriComponentsBuilder builder){

        Pauta pauta = pautaService.inserir(pautaRequestDto);
        URI location = builder.path("/pautas/{id}").buildAndExpand(pauta.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public List<PautaResponseDto> pautas(String tituloPauta){
        return pautaService.lista(tituloPauta);
    }

}
