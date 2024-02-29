package com.lucassbarcelos.springapilab4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucassbarcelos.springapilab4.model.Person;
import com.lucassbarcelos.springapilab4.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepository personRepo;

    @Override
    public void save(Person person) {
        if (person == null) {
            throw new Error("Deu ruim");
        }
        personRepo.save(person);
    }

    @Override
    public List<Person> getPersonList() {
        return personRepo.findAll();
    }

}
