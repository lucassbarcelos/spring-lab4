package com.lucassbarcelos.springapilab4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucassbarcelos.springapilab4.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
