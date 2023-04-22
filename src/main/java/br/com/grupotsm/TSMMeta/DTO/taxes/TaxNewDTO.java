package br.com.grupotsm.TSMMeta.DTO.taxes;

import br.com.grupotsm.TSMMeta.entities.Tax;
import br.com.grupotsm.TSMMeta.entities.enums.TaxType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;



public class TaxNewDTO {

    @NotNull(message = "Nome é necessário")
    @Size(min = 3, max = 12, message = "Nome do imposto deve ter entre 3 a 12 caracteres")
    private String name;

    @NotNull(message = "É necessário informar a porcentagem")
    @Positive
    private Double percentage;

    @NotNull(message = "É necessário informar um tipo")
    @Positive(message = "Tipo inválido")
    private Integer type;

    public TaxNewDTO() {
    }

    public TaxNewDTO(String name, Double percentage, TaxType type) {
        this.name = name;
        this.percentage = percentage;
        this.type = type.getCod();
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public static Tax fromDto(TaxNewDTO dto) {
        Tax obj = new Tax();
        obj.setName(dto.getName());
        obj.setPercentage(dto.getPercentage());
        obj.setType(TaxType.toEnum(dto.getType()));

        return obj;
    }

}
