package br.com.grupotsm.TSMMeta.DTO.employees;

import br.com.grupotsm.TSMMeta.entities.Employee;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class EmployeeResignationDTO {

    @NotNull(message = "É necessário informar a data de desligamento")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate resignationDate;
    public EmployeeResignationDTO() {
    }

    public EmployeeResignationDTO(LocalDate resignationDate) {
        this.resignationDate = resignationDate;
    }

    public EmployeeResignationDTO(Employee obj) {
        resignationDate = obj.getAdmissionDate();
    }
    public LocalDate getResignationDate() {
        return resignationDate;
    }

    public void setResignationDate(LocalDate resignationDate) {
        this.resignationDate = resignationDate;
    }

}
