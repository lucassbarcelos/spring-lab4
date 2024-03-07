package com.lucassbarcelos.springapilab4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucassbarcelos.springapilab4.entity.Anotation;

public interface AnotationRepository extends JpaRepository<Anotation, Long> {

}
