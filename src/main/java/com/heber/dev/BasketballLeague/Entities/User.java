package com.heber.dev.BasketballLeague.Entities;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_user")
    private UUID IDUser;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "paternal", nullable = false)
    private String paternal;

    @Column(name = "maternal", nullable = true)
    private String maternal;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "enabled", nullable = false)
    private Boolean enabled;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "authorities", joinColumns = { @JoinColumn(name = "id_user") }, inverseJoinColumns = {
            @JoinColumn(name = "id_role") })
    Set<Rol> roles = new HashSet<>();
}
