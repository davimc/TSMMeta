package br.com.grupotsm.TSMMeta.entities;

import br.com.grupotsm.TSMMeta.entities.enums.DebitStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_debit")
@Inheritance
public class Debit implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate date;
    private Double amount;
    private Integer status;
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
    public Debit() {
    }

    public Debit(Long id, String name, LocalDate date, Double amount, DebitStatus status, Store store) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.amount = amount;
        this.status = status.getCod();
        this.store = store;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public DebitStatus getStatus() {
        return DebitStatus.toEnum(status);
    }

    public void setStatus(DebitStatus status) {
        this.status = status.getCod();
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Debit debit = (Debit) o;
        return id.equals(debit.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
