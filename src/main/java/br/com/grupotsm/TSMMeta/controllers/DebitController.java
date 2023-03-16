package br.com.grupotsm.TSMMeta.controllers;

import br.com.grupotsm.TSMMeta.DTO.debits.DebitDTO;
import br.com.grupotsm.TSMMeta.DTO.debits.DebitNewDTO;
import br.com.grupotsm.TSMMeta.services.DebitService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/debits")
public class DebitController {
    @Autowired
    private DebitService service;

    @GetMapping()
    public ResponseEntity<Page<DebitDTO>> findALl(Pageable pageable) {
        return ResponseEntity.ok().body(service.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DebitDTO> find(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findDTO(id));
    }

    @PostMapping
    public ResponseEntity<DebitDTO> insert(@Valid @RequestBody DebitNewDTO newDto) {
        DebitDTO dto = service.insert(newDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

   /*
    @PutMapping("/{id}")
    public ResponseEntity<DebitDTO> update(@PathVariable Long id, @Valid @RequestBody DebitUpdateDTO updateDto) {
        DebitDTO dto = service.update(id, updateDto);

        return ResponseEntity.accepted().body(dto);
    }*/
}
