package br.com.grupotsm.TSMMeta.DTO.employees;

import br.com.grupotsm.TSMMeta.entities.Employee;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class EmployeeNewDTO {

    @NotNull(message = "nome é necessário")
    @Size(min = 2, max = 45, message = "tamanho mínimo 2 e máximo 45")
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate admissionDate;

    @NotNull(message = "É necessário informar salário")
    @Positive(message = "Salário não pode ser menor ou igual a 0")
    private Double salary;
    @NotNull(message = "É necessário informar o cargo")
    @Size(min = 2, max = 30, message = "tamanho mínimo 2 e máximo 30")
    private String position;

    @NotNull(message = "É necessário informar uma loja")
    private Long storeId;

    public EmployeeNewDTO() {
    }

    public EmployeeNewDTO(String name, LocalDate admissionDate, Double salary, String position, Long storeId) {
        this.name = name;
        this.admissionDate = admissionDate;
        this.salary = salary;
        this.position = position;
        this.storeId = storeId;
    }

    public EmployeeNewDTO(Employee obj) {
        name = obj.getName();
        admissionDate = obj.getAdmissionDate();
        salary = obj.getSalary();
        position = obj.getPosition();
        storeId = obj.getCurrentStore().getId();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
}
