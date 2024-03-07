package com.lucassbarcelos.springapilab4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucassbarcelos.springapilab4.entity.Authorization;

public interface AuthorizationRepository extends JpaRepository<Authorization, Long> {

}
