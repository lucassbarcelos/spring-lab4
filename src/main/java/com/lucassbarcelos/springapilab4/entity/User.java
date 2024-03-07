package com.lucassbarcelos.springapilab4.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usr_usuario")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_id")
    private Long id;

    @Column(name = "usr_nome")
    private String name;

    @Column(name = "usr_senha")
    private String password;

    @OneToMany(mappedBy = "user")
    private Set<Anotation> anotations;

    @ManyToMany()
    @JoinTable(name = "uau_usuario_autorizacao", joinColumns = { @JoinColumn(name = "usr_id") }, inverseJoinColumns = {
            @JoinColumn(name = "aut_id") })
    private Set<Authorization> authorizations;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Anotation> getAnotations() {
        return anotations;
    }

    public void setAnotations(HashSet<Anotation> anotations) {
        this.anotations = anotations;
    }

    public Set<Authorization> getAuthorizations() {
        return authorizations;
    }

    public void setAuthorizations(HashSet<Authorization> authorizations) {
        this.authorizations = authorizations;
    }
}
