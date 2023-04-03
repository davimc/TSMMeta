package br.com.grupotsm.TSMMeta.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_store")
public class Store implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "currentStore")
    private List<Employee> currentEmployees = new ArrayList<>();
    @OneToMany(mappedBy = "originalStore")
    private List<Employee> originalEmployees = new ArrayList<>();
    @OneToMany(mappedBy = "store")
    private List<Goal> goals = new ArrayList<>();

    public Store() {
    }
    public Store(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getCurrentEmployeers() {
        return currentEmployees;
    }
    public List<Employee> getOriginalEmployeers() {
        return originalEmployees;
    }

    public List<Employee> getCurrentEmployees() {
        return currentEmployees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return id.equals(store.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
