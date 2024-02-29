package com.lucassbarcelos.springapilab4.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucassbarcelos.springapilab4.model.Person;
import com.lucassbarcelos.springapilab4.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonService personService;

    @GetMapping()
    public List<Person> getAll() {
        return personService.getPersonList();
    }

    @PostMapping()
    public void save(String firstName, String lastName) {
        Person pessoa = new Person();
        pessoa.setfirstName(firstName);
        pessoa.setlastName(lastName);
        personService.save(pessoa);
    }

}