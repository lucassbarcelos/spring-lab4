package com.lucassbarcelos.springapilab4.service;

import java.util.List;

import com.lucassbarcelos.springapilab4.entity.Body;

public interface BodyService {

    public List<Body> getAll();

    public Body save(Body body);

    public List<Body> getByNameAndDiameter(String name, Integer diameter);
}
