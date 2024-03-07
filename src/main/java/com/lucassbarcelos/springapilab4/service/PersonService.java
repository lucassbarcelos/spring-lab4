package com.lucassbarcelos.springapilab4.service;

import java.util.List;

import com.lucassbarcelos.springapilab4.entity.Person;

public interface PersonService {
    void save(Person person);

    List<Person> getPersonList();
}