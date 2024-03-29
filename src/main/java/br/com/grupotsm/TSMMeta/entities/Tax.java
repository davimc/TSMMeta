package br.com.grupotsm.TSMMeta.entities;

import br.com.grupotsm.TSMMeta.entities.enums.TaxType;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "tb_tax")
public class Tax implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double percentage;

    private Integer type;

    @ManyToMany
    @JoinTable(name = "tb_taxes_stores",
            joinColumns = @JoinColumn(name = "tax_id"),
        inverseJoinColumns = @JoinColumn(name = "store_id"))
    private Set<Store> stores = new HashSet<>();

    public Tax() {
    }

    public Tax(Long id, String name, Double percentage, TaxType type) {
        this.id = id;
        this.name = name;
        this.percentage = percentage;
        this.type = type.getCod();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public Set<Store> getStores() {
        return stores;
    }

    public TaxType getType() {
        return TaxType.toEnum(type);
    }

    public void setType(TaxType type) {
        this.type = type.getCod();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tax tax = (Tax) o;
        return id.equals(tax.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
