package br.com.grupotsm.TSMMeta.DTO.goals;

import br.com.grupotsm.TSMMeta.entities.Goal;
import br.com.grupotsm.TSMMeta.entities.Store;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class GoalNewDTO {

    @NotNull(message = "data é necessário")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @NotNull(message = "É necessário informar uma loja")
    private Long storeId;

    public GoalNewDTO() {
    }

    public GoalNewDTO(LocalDate date, Long storeId) {
        this.date = date;
        this.storeId = storeId;
    }

    public GoalNewDTO(Goal obj) {
        date = obj.getDate();
        storeId = obj.getStore().getId();
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public static Goal fromDto(GoalNewDTO dto, Store store, Double target) {
        Goal obj = new Goal();

        obj.setDate(dto.getDate());
        obj.setStore(store);
        obj.setAmount(0.0);
        obj.setTarget(target);

        return obj;
    }
}
