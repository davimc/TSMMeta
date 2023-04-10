package br.com.grupotsm.TSMMeta.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_tax")
public class Tax implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double percentage;

    @ManyToMany
    @JoinTable(name = "tb_taxes_stores",
            joinColumns = @JoinColumn(name = "tax_id"),
        inverseJoinColumns = @JoinColumn(name = "store_id"))
    private List<Store> stores = new ArrayList<>();

    public Tax() {
    }

    public Tax(String name, Double percentage) {
        this.name = name;
        this.percentage = percentage;
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

    public List<Store> getStores() {
        return stores;
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
