package com.transporteboaglio.TB.entity;

import com.transporteboaglio.TB.enumeration.Erole;
import jakarta.persistence.*;
import lombok.Builder;


@Entity
@Builder
@Table(name = "roles")
public class RoleEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Erole name;

    public RoleEntity() {
    }

    public RoleEntity(Long id, Erole name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Erole getName() {
        return name;
    }

    public void setName(Erole name) {
        this.name = name;
    }
}
