package br.com.grupotsm.TSMMeta.DTO.stores;

import br.com.grupotsm.TSMMeta.entities.Store;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class StoreNewDTO {

    @NotNull(message = "nome é necessário")
    @Size(min = 2, max = 45, message = "tamanho mínimo 2 e máximo 45")
    private String name;

    public StoreNewDTO() {
    }

    public StoreNewDTO(String name) {
        this.name = name;
    }

    public StoreNewDTO(Store obj) {
        name = obj.getName();
    }

    public static Store fromDto(StoreNewDTO dto) {
        Store obj = new Store();
        obj.setName(dto.getName());

        return obj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
