package com.lucassbarcelos.springapilab4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.lucassbarcelos.springapilab4.entity.Body;
import com.lucassbarcelos.springapilab4.repository.BodyRepository;

@Service
public class BodyServiceImpl implements BodyService {
    @Autowired
    BodyRepository bodyRepo;

    @Override
    public Body save(Body body) {
        if (validadeBody(body)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No body send");
        }

        Body savedBody = bodyRepo.save(body);

        return savedBody;
    }

    @Override
    public List<Body> getAll() {
        return bodyRepo.findAll();
    }

    @Override
    public List<Body> getByNameAndDiameter(String name, Integer diameter) {
        return bodyRepo.getByNameLikeOrDiameter(name, diameter);
    }

    private Boolean validadeBody(Body body) {
        if (body == null || body.getName() == null || body.getName().isBlank() || body.getDescription() == null
                || body.getDescription().isBlank() || body.getDiameter() == null
                || body.getDiameter() <= 0) {
            return true;
        }
        return false;
    }

}
