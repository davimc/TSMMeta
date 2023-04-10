package br.com.grupotsm.TSMMeta.controllers;

import br.com.grupotsm.TSMMeta.DTO.taxes.TaxDTO;
import br.com.grupotsm.TSMMeta.DTO.taxes.TaxNewDTO;
import br.com.grupotsm.TSMMeta.services.TaxService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/taxes")
public class TaxController {
    @Autowired
    private TaxService service;

    @GetMapping()
    public ResponseEntity<Page<TaxDTO>> findALl(Pageable pageable) {
        return ResponseEntity.ok().body(service.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaxDTO> find(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findDTO(id));
    }

    @PostMapping
    public ResponseEntity<TaxDTO> insert(@Valid @RequestBody TaxNewDTO newDto) {
        TaxDTO dto = service.insert(newDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
