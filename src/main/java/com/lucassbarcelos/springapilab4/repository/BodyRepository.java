package com.lucassbarcelos.springapilab4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lucassbarcelos.springapilab4.entity.Body;

public interface BodyRepository extends JpaRepository<Body, Long> {

    @Query("select b from Body b where b.name like %?1% or b.diameter > 0")
    public List<Body> getByNameLike(String name);
}
