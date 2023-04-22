package br.com.grupotsm.TSMMeta.DTO.debits;

import br.com.grupotsm.TSMMeta.entities.Debit;
import br.com.grupotsm.TSMMeta.entities.DebitFrequent;
import br.com.grupotsm.TSMMeta.entities.User;
import br.com.grupotsm.TSMMeta.entities.enums.DebitStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class DebitNewDTO {

    @NotNull(message = "nome é necessário")
    @Size(min = 2, max = 45, message = "tamanho mínimo 2 e máximo 45")
    private String name;

    @NotNull(message = "data é necessário")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @NotNull(message = "custo é necessário")
    @Positive
    private Double amount;

    @PositiveOrZero(message = "a repetição da dívida precisa ser positiva")
    private Integer frequency;

    @NotNull(message = "é necessário informar a loja")
    private Long storeId;

    public DebitNewDTO() {
    }

    public DebitNewDTO(String name, LocalDate date, Double amount, Integer frequency, Long storeId) {
        this.name = name;
        this.date = date;
        this.amount = amount;
        this.frequency = frequency;
        this.storeId = storeId;
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

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public static Debit fromDto(DebitNewDTO dto) {
        Debit obj = dto.getFrequency() == null? new Debit() : new DebitFrequent();
        obj.setName(dto.getName());
        obj.setAmount(dto.getAmount());
        obj.setDate(dto.getDate());
        obj.setStatus(DebitStatus.ACTIVE);
        if(obj instanceof DebitFrequent)
            ((DebitFrequent) obj).setFrequency(dto.getFrequency());

        return obj;
    }
}
