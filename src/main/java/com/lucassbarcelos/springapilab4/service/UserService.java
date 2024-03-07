package com.lucassbarcelos.springapilab4.service;

import java.util.List;

import com.lucassbarcelos.springapilab4.entity.User;

public interface UserService {
    List<User> getAll();

    User save(User user);

    User findById(Long id);
}
