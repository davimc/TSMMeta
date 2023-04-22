package br.com.grupotsm.TSMMeta.DTO.debits;

import br.com.grupotsm.TSMMeta.entities.Debit;
import br.com.grupotsm.TSMMeta.entities.DebitFrequent;
import br.com.grupotsm.TSMMeta.entities.enums.DebitStatus;

import java.io.Serializable;
import java.time.LocalDate;

public class DebitDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private LocalDate date;
    private Double amount;
    private String status;
    private Integer frequency;
    private String store;

    public DebitDTO() {
    }

    public DebitDTO(Long id, String name, LocalDate date, Double amount, DebitStatus status, Integer frequency, String store) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.amount = amount;
        this.status = status.getDesc();
        this.frequency = frequency;
        this.store = store;
    }

    public DebitDTO(Debit obj) {
        id = obj.getId();
        name = obj.getName();
        date = obj.getDate();
        amount = obj.getAmount();
        status = obj.getStatus().getDesc();
        store = obj.getStore().getName();
        try {
            frequency = ((DebitFrequent) obj).getFrequency();
        }catch (ClassCastException e) {

        }

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

    public String getStatus() {
        return status;
    }

    public String getStore() {
        return store;
    }

    public Integer getFrequency() {
        return frequency;
    }
}
