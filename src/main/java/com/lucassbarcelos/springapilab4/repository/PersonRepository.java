package com.lucassbarcelos.springapilab4.repository;

import org.springframework.stereotype.Repository;

import com.lucassbarcelos.springapilab4.entity.Person;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
