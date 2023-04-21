package br.com.grupotsm.TSMMeta.DTO.debits;

import br.com.grupotsm.TSMMeta.entities.Debit;
import br.com.grupotsm.TSMMeta.entities.User;
import br.com.grupotsm.TSMMeta.entities.enums.DebitStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

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

    public DebitNewDTO() {
    }

    public DebitNewDTO(String name, LocalDate date, Double amount) {
        this.name = name;
        this.date = date;
        this.amount = amount;
    }

    public DebitNewDTO(Debit obj) {
        name = obj.getName();
        date = obj.getDate();
        amount = obj.getAmount();
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

    public static Debit fromDto(DebitNewDTO dto) {
        Debit obj = new Debit();
        obj.setName(dto.getName());
        obj.setAmount(dto.getAmount());
        obj.setDate(dto.getDate());
        obj.setStatus(DebitStatus.ACTIVE);

        return obj;
    }
}
