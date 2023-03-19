package br.com.grupotsm.TSMMeta.DTO.employees;

import br.com.grupotsm.TSMMeta.entities.Debit;
import br.com.grupotsm.TSMMeta.entities.Employee;

import java.io.Serializable;
import java.time.LocalDate;

public class EmployeeDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private LocalDate admissionDate;
    private LocalDate resignationDate;
    private Double salary;
    private String position;
    private String originalStore;
    private String currentStore;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Long id, String name, LocalDate admissionDate, LocalDate resignationDate, Double salary, String position, String originalStore, String currentStore) {
        this.id = id;
        this.name = name;
        this.admissionDate = admissionDate;
        this.resignationDate = resignationDate;
        this.salary = salary;
        this.position = position;
        this.originalStore = originalStore;
        this.currentStore = currentStore;
    }

    public EmployeeDTO(Employee obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.admissionDate = obj.getAdmissionDate();
        this.resignationDate = obj.getResignationDate();
        this.salary = obj.getSalary();
        this.position = obj.getPosition();
        this.originalStore = obj.getOriginalStore().getName();
        this.currentStore = obj.getCurrentStore().getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public LocalDate getResignationDate() {
        return resignationDate;
    }

    public Double getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    public String getOriginalStore() {
        return originalStore;
    }

    public String getCurrentStore() {
        return currentStore;
    }
}
