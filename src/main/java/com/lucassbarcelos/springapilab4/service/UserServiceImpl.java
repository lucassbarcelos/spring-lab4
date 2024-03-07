package com.lucassbarcelos.springapilab4.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.lucassbarcelos.springapilab4.entity.Authorization;
import com.lucassbarcelos.springapilab4.entity.User;
import com.lucassbarcelos.springapilab4.repository.AuthorizationRepository;
import com.lucassbarcelos.springapilab4.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepo;

    @Autowired
    AuthorizationRepository authorizationRepo;

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public User save(User user) {
        if (validadeUser(user)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No user send");
        }

        if (user.getAuthorizations() != null && !user.getAuthorizations().isEmpty()) {
            setAuthorizations(user);
        }

        User savedUser = userRepo.save(user);

        return savedUser;
    }

    private void setAuthorizations(User user) {
        Set<Authorization> authorizations = new HashSet<Authorization>(user.getAuthorizations());

        Set<Long> authorizationIds = new HashSet<Long>();

        authorizations.forEach(item -> authorizationIds.add(item.getId()));

        user.setAuthorizations(new HashSet<Authorization>(authorizationRepo.findAllById(authorizationIds)));
    }

    private Boolean validadeUser(User user) {
        if (user == null || user.getName() == null || user.getName().isBlank() || user.getPassword() == null
                || user.getPassword().isBlank()) {
            return true;
        }
        return false;
    }

    @Override
    public User findById(Long id) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No id passed");
        }

        Optional<User> user = userRepo.findById(id);

        if (user.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found");
        }

        return user.get();
    }
}
