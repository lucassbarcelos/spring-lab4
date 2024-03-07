package com.lucassbarcelos.springapilab4.service;

import java.util.List;

import com.lucassbarcelos.springapilab4.entity.Authorization;

public interface AuthorizationService {
    Authorization save(Authorization authorization);

    List<Authorization> getAll();

    Authorization findById(Long id);

}