package com.lucassbarcelos.springapilab4.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucassbarcelos.springapilab4.entity.Body;
import com.lucassbarcelos.springapilab4.service.BodyService;

@RestController
@RequestMapping("/body")
public class BodyController {
    @Autowired
    BodyService bodyService;

    @CrossOrigin("http://localhost:5173/")
    @GetMapping()
    public List<Body> getAll() {
        return bodyService.getAll();
    }

    @CrossOrigin("http://localhost:5173/")
    @PostMapping()
    public Body create(@RequestBody Body body) {
        return bodyService.save(body);
    }

    @CrossOrigin("http://localhost:5173/")
    @GetMapping("/getbyname")
    public List<Body> getByName(String name, Integer diameter) {
        return bodyService.getByNameAndDiameter(name, diameter);
    }
}
