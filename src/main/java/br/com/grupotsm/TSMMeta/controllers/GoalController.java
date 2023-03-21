package br.com.grupotsm.TSMMeta.controllers;

import br.com.grupotsm.TSMMeta.DTO.goals.GoalDTO;
import br.com.grupotsm.TSMMeta.DTO.goals.GoalNewDTO;
import br.com.grupotsm.TSMMeta.services.GoalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/goals")
public class GoalController {
    @Autowired
    private GoalService service;

    @GetMapping()
    public ResponseEntity<Page<GoalDTO>> findALl(Pageable pageable) {
        return ResponseEntity.ok().body(service.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GoalDTO> find(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findDTO(id));
    }

    /*todo GoalService 36:5
    @PostMapping
    public ResponseEntity<GoalDTO> insert(@Valid @RequestBody GoalNewDTO newDto) {
        GoalDTO dto = service.insert(newDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }*/

   /*
    @PutMapping("/{id}")
    public ResponseEntity<GoalDTO> update(@PathVariable Long id, @Valid @RequestBody GoalUpdateDTO updateDto) {
        GoalDTO dto = service.update(id, updateDto);

        return ResponseEntity.accepted().body(dto);
    }*/
}
