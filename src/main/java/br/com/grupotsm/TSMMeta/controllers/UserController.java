package br.com.grupotsm.TSMMeta.controllers;

import br.com.grupotsm.TSMMeta.DTO.UserDTO;
import br.com.grupotsm.TSMMeta.DTO.UserNewDTO;
import br.com.grupotsm.TSMMeta.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping()
    public ResponseEntity<Page<UserDTO>> findALl(Pageable pageable) {
        return ResponseEntity.ok().body(service.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> find(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.find(id));
    }

    @PostMapping
    public ResponseEntity<UserDTO> insert(@RequestBody @Valid UserNewDTO newDto) {
        UserDTO dto = service.insert(newDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
