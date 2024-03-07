package com.lucassbarcelos.springapilab4.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucassbarcelos.springapilab4.entity.Authorization;
import com.lucassbarcelos.springapilab4.service.AuthorizationService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/authorization")
public class AuthorizationController {
    @Autowired
    AuthorizationService authorizationService;

    @GetMapping()
    public List<Authorization> getAll() {
        return authorizationService.getAll();
    }

    @PostMapping()
    public Authorization save(@RequestBody Authorization authorization) {
        return authorizationService.save(authorization);
    }

    @GetMapping("/{id}")
    public Authorization getById(@PathParam("id") Long id) {
        return authorizationService.findById(id);
    }
}
