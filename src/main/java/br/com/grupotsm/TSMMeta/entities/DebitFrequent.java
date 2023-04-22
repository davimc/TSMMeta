package br.com.grupotsm.TSMMeta.entities;

import br.com.grupotsm.TSMMeta.entities.enums.DebitStatus;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
@DiscriminatorValue(value = "F")
public class DebitFrequent extends Debit{
    private Integer frequency;

    public DebitFrequent() {
    }

    public DebitFrequent(Long id, String name, LocalDate date, Double amount, DebitStatus status, Store store, Integer frequency) {
        super(id, name, date, amount, status, store);
        this.frequency = frequency;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }
}
