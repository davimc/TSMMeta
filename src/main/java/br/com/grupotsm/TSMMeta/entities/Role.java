package br.com.grupotsm.TSMMeta.entities;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

@Entity
@Table(name = "tb_role")
public class Role implements GrantedAuthority, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String authority;

    public Role() {
    }

    public Role(String name) {
        this.id = id;
        this.authority = name;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
