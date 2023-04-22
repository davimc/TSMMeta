package br.com.grupotsm.TSMMeta.DTO.taxes;

import br.com.grupotsm.TSMMeta.entities.Tax;
import br.com.grupotsm.TSMMeta.entities.enums.TaxType;

import java.io.Serializable;

public class TaxDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private Double percentage;
    private String type;
    
    public TaxDTO() {
    }

    public TaxDTO(Long id, String name, Double percentage, TaxType type) {
        this.id = id;
        this.name = name;
        this.percentage = percentage;
        this.type = type.getDesc();
    }

    public TaxDTO(Tax obj) {
        id = obj.getId();
        name = obj.getName();
        percentage = obj.getPercentage();
        type = obj.getType().getDesc();

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

    public String getType() {
        return type;
    }
}
