package br.com.grupotsm.TSMMeta.DTO.taxes;

import br.com.grupotsm.TSMMeta.entities.Goal;
import br.com.grupotsm.TSMMeta.entities.Store;
import br.com.grupotsm.TSMMeta.entities.Tax;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class TaxNewDTO {

    @NotNull(message = "Nome é necessário")
    @Size(min = 3, max = 12, message = "Nome do imposto deve ter entre 3 a 12 caracteres")
    private String name;

    @NotNull(message = "É necessário informar a porcentagem")
    @Positive
    private Double percentage;

    public TaxNewDTO() {
    }

    public TaxNewDTO(String name, Double percentage) {
        this.name = name;
        this.percentage = percentage;
    }

    public TaxNewDTO(Tax obj) {
        name = obj.getName();
        percentage = obj.getPercentage();
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

    public static Tax fromDto(TaxNewDTO dto) {
        Tax obj = new Tax();
        obj.setName(dto.getName());
        obj.setPercentage(dto.getPercentage());

        return obj;
    }

}
