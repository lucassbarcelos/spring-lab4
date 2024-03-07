package com.lucassbarcelos.springapilab4.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.lucassbarcelos.springapilab4.entity.Anotation;
import com.lucassbarcelos.springapilab4.repository.AnotationRepository;

@Service
public class AnotationServiceImpl implements AnotationService {
    @Autowired
    AnotationRepository anotationRepo;

    @Autowired
    UserService userService;

    @Override
    public List<Anotation> getAll() {
        return anotationRepo.findAll();
    }

    @Override
    public Anotation save(Anotation anotation) {
        if (validadeAnotation(anotation)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No anotation send");
        }

        anotation.setUser(userService.findById(anotation.getUser().getId()));

        Anotation savedAnotation = anotationRepo.save(anotation);

        return savedAnotation;
    }

    private Boolean validadeAnotation(Anotation anotation) {
        if (anotation == null || anotation.getText().isBlank()
                || anotation.getText() == null
                || anotation.getUser() == null || anotation.getUser().getId() == null) {

            return true;
        }
        if (anotation.getDateTime() == null) {
            anotation.setDateTime(LocalDateTime.now());
        }
        return false;
    }

    @Override
    public Anotation findById(Long id) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No id passed");
        }

        Optional<Anotation> anotation = anotationRepo.findById(id);

        if (anotation.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "anotation not found");
        }

        return anotation.get();
    }

}
