package com.lucassbarcelos.springapilab4.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*
 * create table cor_corpo (
  cor_id bigint primary key auto_increment,
  cor_nome varchar(100) not null unique,
  cor_descricao varchar(200) not null,
  cor_diametro int not null,
  cor_distancia_estrela float
);

 */
@Entity
@Table(name = "cor_corpo")
public class Body {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cor_id")
    private Long id;

    @Column(name = "cor_nome")
    private String name;

    @Column(name = "cor_descricao")
    private String description;

    @Column(name = "cor_diametro")
    private Integer diameter;

    @Column(name = "cor_distancia_estrela")
    private Float distance;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDiameter() {
        return diameter;
    }

    public void setDiameter(Integer diameter) {
        this.diameter = diameter;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }
}
