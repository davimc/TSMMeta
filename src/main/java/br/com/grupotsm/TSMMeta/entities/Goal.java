package br.com.grupotsm.TSMMeta.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_goal")
public class Goal implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store storeId;

    @OneToMany(mappedBy = "goal")
    private List<Debit> debits = new ArrayList<>();

    public Goal() {
    }

    public Goal(Long id, LocalDate date, Double amount, Store storeId) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.storeId = storeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Store getStoreId() {
        return storeId;
    }

    public void setStoreId(Store storeId) {
        this.storeId = storeId;
    }

    public List<Debit> getDebits() {
        return debits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goal goal = (Goal) o;
        return id.equals(goal.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
