package br.com.grupotsm.TSMMeta.DTO.stores;

import br.com.grupotsm.TSMMeta.entities.Store;

import java.io.Serializable;

public class StoreWithTaxesDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;


    public StoreWithTaxesDTO() {
    }

    public StoreWithTaxesDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public StoreWithTaxesDTO(Store obj) {
        id = obj.getId();
        name = obj.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
