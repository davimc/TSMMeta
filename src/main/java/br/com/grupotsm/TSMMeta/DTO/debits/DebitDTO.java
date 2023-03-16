package br.com.grupotsm.TSMMeta.DTO.debits;

import br.com.grupotsm.TSMMeta.entities.Debit;

import java.io.Serializable;
import java.time.LocalDate;

public class DebitDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private LocalDate date;
    private Double amount;

    public DebitDTO() {
    }

    public DebitDTO(Long id, String name, LocalDate date, Double amount) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.amount = amount;
    }

    public DebitDTO(Debit obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.date = obj.getDate();
        this.amount = obj.getAmount();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public Double getAmount() {
        return amount;
    }
}
