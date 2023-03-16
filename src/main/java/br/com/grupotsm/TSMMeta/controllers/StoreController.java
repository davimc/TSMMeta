package br.com.grupotsm.TSMMeta.controllers;

import br.com.grupotsm.TSMMeta.DTO.stores.StoreDTO;
import br.com.grupotsm.TSMMeta.DTO.stores.StoreNewDTO;
import br.com.grupotsm.TSMMeta.DTO.stores.StoreUpdateDTO;
import br.com.grupotsm.TSMMeta.services.StoreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/stores")
public class StoreController {
    @Autowired
    private StoreService service;

    @GetMapping()
    public ResponseEntity<Page<StoreDTO>> findALl(Pageable pageable) {
        return ResponseEntity.ok().body(service.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreDTO> find(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findDTO(id));
    }

    @PostMapping
    public ResponseEntity<StoreDTO> insert(@Valid @RequestBody StoreNewDTO newDto) {
        StoreDTO dto = service.insert(newDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StoreDTO> update(@PathVariable Long id, @Valid @RequestBody StoreUpdateDTO updateDto) {
        StoreDTO dto = service.update(id, updateDto);

        return ResponseEntity.accepted().body(dto);
    }
}
