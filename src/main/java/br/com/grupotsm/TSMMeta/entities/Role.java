package br.com.grupotsm.TSMMeta.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String authority;

    public Role() {
    }

    public Role(Long id, String name) {
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
