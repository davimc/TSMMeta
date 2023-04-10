package br.com.grupotsm.TSMMeta.DTO.taxes;

import br.com.grupotsm.TSMMeta.entities.Tax;

import java.io.Serializable;
import java.time.Month;

public class TaxDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private Double percentage;
    
    public TaxDTO() {
    }

    public TaxDTO(Long id, String name, Double percentage) {
        this.id = id;
        this.name = name;
        this.percentage = percentage;
    }

    public TaxDTO(Tax obj) {
        id = obj.getId();
        name = obj.getName();
        percentage = obj.getPercentage();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPercentage() {
        return percentage;
    }
}
