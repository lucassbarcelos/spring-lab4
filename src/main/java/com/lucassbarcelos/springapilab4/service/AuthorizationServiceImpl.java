package com.lucassbarcelos.springapilab4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.lucassbarcelos.springapilab4.entity.Authorization;
import com.lucassbarcelos.springapilab4.repository.AuthorizationRepository;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {
    @Autowired
    AuthorizationRepository authorizationRepo;

    @Override
    public List<Authorization> getAll() {
        return authorizationRepo.findAll();
    }

    @SuppressWarnings("null")
    @Override
    public Authorization save(Authorization authorization) {
        if (validadeAuthorization(authorization)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No authorization send");
        }
        Authorization savedAuthorization = authorizationRepo.save(authorization);

        return savedAuthorization;
    }

    private Boolean validadeAuthorization(Authorization authorization) {
        if (authorization == null || authorization.getName() == null || authorization.getName().isBlank()
                || authorization.getUsers().isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public Authorization findById(Long id) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No id passed");
        }

        Optional<Authorization> authorization = authorizationRepo.findById(id);

        if (authorization.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "authorization not found");
        }

        return authorization.get();
    }

}
