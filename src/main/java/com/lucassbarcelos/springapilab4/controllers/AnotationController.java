package com.lucassbarcelos.springapilab4.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucassbarcelos.springapilab4.entity.Anotation;
import com.lucassbarcelos.springapilab4.service.AnotationService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/anotation")
public class AnotationController {
    @Autowired
    AnotationService anotationService;

    @GetMapping()
    public List<Anotation> getAll() {
        return anotationService.getAll();
    }

    @PostMapping()
    public Anotation save(@RequestBody Anotation anotation) {
        return anotationService.save(anotation);
    }

    @GetMapping("/{id}")
    public Anotation getById(@PathParam("id") Long id) {
        return anotationService.findById(id);
    }
}
