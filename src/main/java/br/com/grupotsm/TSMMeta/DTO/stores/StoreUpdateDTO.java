package br.com.grupotsm.TSMMeta.DTO.stores;

import br.com.grupotsm.TSMMeta.entities.Store;
import jakarta.validation.constraints.Size;

public class StoreUpdateDTO {

    @Size(min = 2, max = 30, message = "Tamanho deve ser superior a 2 e inferior a 30")
    private String name;

    public StoreUpdateDTO() {
    }

    public StoreUpdateDTO(String name) {
        this.name = name;
    }

    public StoreUpdateDTO(Store obj) {
        this.name = obj.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
