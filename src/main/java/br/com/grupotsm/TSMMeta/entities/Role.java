package br.com.grupotsm.TSMMeta.entities;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "tb_role")
public class Role implements GrantedAuthority {

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
