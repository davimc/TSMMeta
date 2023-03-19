package br.com.grupotsm.TSMMeta.controllers;

import br.com.grupotsm.TSMMeta.DTO.employees.EmployeeDTO;
import br.com.grupotsm.TSMMeta.DTO.employees.EmployeeNewDTO;
import br.com.grupotsm.TSMMeta.DTO.employees.EmployeeResignationDTO;
import br.com.grupotsm.TSMMeta.DTO.employees.EmployeeUpdateInfosDTO;
import br.com.grupotsm.TSMMeta.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping()
    public ResponseEntity<Page<EmployeeDTO>> findALl(Pageable pageable) {
        return ResponseEntity.ok().body(service.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> find(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findDTO(id));
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> insert(@Valid @RequestBody EmployeeNewDTO newDto) {
        EmployeeDTO dto = service.insert(newDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> update(@PathVariable Long id, @Valid @RequestBody EmployeeUpdateInfosDTO updateDto) {
        EmployeeDTO dto = service.update(id, updateDto);

        return ResponseEntity.accepted().body(dto);
    }
    @PutMapping("/dismiss/{id}")
    public ResponseEntity<EmployeeDTO> update(@PathVariable Long id, @Valid @RequestBody EmployeeResignationDTO updateDto) {
        EmployeeDTO dto = service.dismiss(id, updateDto);

        return ResponseEntity.accepted().body(dto);
    }
}
