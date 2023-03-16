package br.com.grupotsm.TSMMeta.DTO.stores;

import br.com.grupotsm.TSMMeta.entities.Store;

import java.io.Serializable;
import java.time.LocalDate;

public class StoreDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;

    public StoreDTO() {
    }

    public StoreDTO(Long id, String name) {
        this.id = id;
        this.name = name;

    }
    public StoreDTO(Store obj) {
        this.id = obj.getId();
        this.name = obj.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
