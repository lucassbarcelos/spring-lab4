package com.lucassbarcelos.springapilab4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.lucassbarcelos.springapilab4.model.User;
import com.lucassbarcelos.springapilab4.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepo;

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public User save(User user) {
        if (validadeUser(user)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No user send");
        }
        User savedUser = userRepo.save(user);

        return savedUser;
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
