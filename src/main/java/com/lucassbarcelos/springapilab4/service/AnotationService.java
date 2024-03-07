package com.lucassbarcelos.springapilab4.service;

import java.util.List;

import com.lucassbarcelos.springapilab4.entity.Anotation;

public interface AnotationService {
    Anotation save(Anotation anotation);

    List<Anotation> getAll();

    Anotation findById(Long id);
}
