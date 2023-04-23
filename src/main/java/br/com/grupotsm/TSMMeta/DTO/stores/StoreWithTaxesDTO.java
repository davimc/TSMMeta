package br.com.grupotsm.TSMMeta.DTO.stores;

import br.com.grupotsm.TSMMeta.DTO.taxes.TaxDTO;
import br.com.grupotsm.TSMMeta.entities.Store;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StoreWithTaxesDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;

    private List<TaxDTO> taxes = new ArrayList<>();

    public StoreWithTaxesDTO() {
    }

    public StoreWithTaxesDTO(Long id, String name, List<TaxDTO> taxes) {
        this.id = id;
        this.name = name;
        this.taxes = taxes;
    }
    public StoreWithTaxesDTO(Store obj) {
        id = obj.getId();
        name = obj.getName();
        taxes = obj.getTaxes().stream().map(TaxDTO::new).toList();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<TaxDTO> getTaxes() {
        return taxes;
    }
}
