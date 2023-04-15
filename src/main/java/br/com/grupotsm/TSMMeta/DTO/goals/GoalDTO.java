package br.com.grupotsm.TSMMeta.DTO.goals;

import br.com.grupotsm.TSMMeta.entities.Goal;

import java.io.Serializable;
import java.time.Month;

public class GoalDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Month month;
    private Integer year;
    private Double target;
    private Double amount;

    private String store;
    public GoalDTO() {
    }

    public GoalDTO(Long id, Month month, Integer year, Double target, Double amount, String store) {
        this.id = id;
        this.month = month;
        this.year = year;
        this.target = target;
        this.amount = amount;
        this.store = store;
    }

    public GoalDTO(Goal obj) {
        id = obj.getId();
        month = obj.getDate().getMonth();
        year = obj.getDate().getYear();
        target = obj.getTarget();
        amount = obj.getAmount();
        store = obj.getStore().getName();
    }

    public Long getId() {
        return id;
    }

    public Month getMonth() {
        return month;
    }

    public Integer getYear() {
        return year;
    }

    public String getStore() {
        return store;
    }

    public Double getTarget() {
        return target;
    }

    public Double getAmount() {
        return amount;
    }

}
